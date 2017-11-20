package com.tsystems.jschool.railway.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsystems.jschool.railway.dto.Board;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
@Singleton
@ApplicationScoped
public class BoardController {

    private static final String BOARDS_BY_STATION_URL = "http://localhost:8080/jschool-1.0/getStationBoard/";
    private String stationName = "Sochi";
    private List<Board> boards;
    private ObjectMapper mapper;

    public void updateBoard(){
        String jsonString = update(BOARDS_BY_STATION_URL + stationName);
        if (jsonString != null) {
            List<Board> list = null;
            try {
                list = mapper.readValue(jsonString,
                        new TypeReference<List<Board>>() {
                        });

            } catch (IOException e) {
                e.printStackTrace();
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

    public BoardController() {
        boards = new ArrayList<>();
        mapper = new ObjectMapper();
    }
    public List<Board> getBoards() {
        return boards;
    }
    public String getStationName(){
        return stationName;
    }
    public String setStationName(String stationName) {
        this.stationName = stationName;
        updateBoard();
        return "board";
    }
}
