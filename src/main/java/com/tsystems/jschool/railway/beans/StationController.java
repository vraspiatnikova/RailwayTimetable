package com.tsystems.jschool.railway.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
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
public class StationController {

    private static final Logger LOGGER = Logger.getLogger(StationController.class);
    private List<String> stations;
    private ObjectMapper mapper;
    private static final String STATION_NAMES_URL = "http://localhost:8080/jschool-1.0/getAllStations";

    public StationController() {
        this.stations = new ArrayList<>();
        this.mapper = new ObjectMapper();
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    @PostConstruct
    public void init(){
        loadStations();
    }

    private void loadStations() {
        String jsonString = update(STATION_NAMES_URL );
        if (jsonString != null) {
            List<String> list = null;
            try {
                list = mapper.readValue(jsonString,
                        new TypeReference<List<String>>() {
                        });

            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
            stations = list;
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
}
