package com.tsystems.jschool.railway.beans;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsystems.jschool.railway.dto.Board;
import com.tsystems.jschool.railway.dto.SortedBoard;
import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Singleton
public class BoardService {

    private static final Logger LOGGER = Logger.getLogger(BoardController.class);
    private static final String BOARDS_BY_STATION_URL = "http://localhost:8080/jschool-1.0/getStationBoard/";
    private String stationName;
    private List<Board> boards;
    private ObjectMapper mapper;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public boolean isBoardsContainsId(String msg){
        String[] arr = msg.split(" ");
        int id = Integer.parseInt(arr[1]);
        LOGGER.info("try to check if boards contains id (" + id + ")");
        for (Board board: boards){
            if (board.getBoardId() == id) return true;
        }
        return false;
    }

    public boolean checkForOldBoards(){
        boolean result = false;
        try {
            for (Board board: boards){
                if (format.parse(board.getDepatureDateTime()).before(new Date())){
                    result = true;
                }
            }
        } catch (ParseException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public void updateOneBoard(String msg){
        String[] arr = msg.split(" ");
        int id = Integer.parseInt(arr[1]);
        LOGGER.info("try to update board with id (" + id + ")");
        int delta = Integer.parseInt(arr[2]);
        for (Board board: boards){
            if (board.getBoardId() == id){
                try {
                    Date arrivalDate = format.parse(board.getArrivaDatelTime());
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(arrivalDate);
                    calendar.add(Calendar.MINUTE, delta);
                    board.setArrivaDatelTime(format.format(calendar.getTime()));

                    Date departureDate = format.parse(board.getDepatureDateTime());
                    calendar.setTime(departureDate);
                    calendar.add(Calendar.MINUTE, delta);
                    board.setDepatureDateTime(format.format(calendar.getTime()));
                } catch (ParseException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        boards.sort(new SortedBoard());
    }

    public void updateBoard(){
        LOGGER.info("try to update board by station " + getStationName());
        String jsonString = update(BOARDS_BY_STATION_URL + getStationName());
        if (jsonString != null) {
            List<Board> list = null;
            try {
                list = mapper.readValue(jsonString,
                        new TypeReference<List<Board>>() {
                        });

            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
            boards = list;
        }
    }
    private String update(String url) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(url);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).get();
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        }
        response.close();
        return null;
    }

    @PostConstruct
    public void init(){
        updateBoard();
    }

    public BoardService() {
        boards = new ArrayList<>();
        mapper = new ObjectMapper();
    }


    public List<Board> getBoards() {
        return boards;
    }

    public String getStationName(){
        return this.stationName;
    }

    public void setStationName(String name){
        if(!name.isEmpty() && !name.equals("")){
        this.stationName = name;
        updateBoard();
        }
    }
}
