package com.ciandt.hackathon.sorocaba.http;

import com.ciandt.hackathon.sorocaba.R;
import com.ciandt.hackathon.sorocaba.entity.Reservoir;
import com.ciandt.hackathon.sorocaba.entity.State;
import com.ciandt.hackathon.sorocaba.util.BusinessException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Ticket singleton service for HTTP calls.
 *
 * @author falvojr
 */
public class HttpService {

    private static final String API_APP = "http://192.168.5.109:3000/hackathon/api/v1";
    private static final String API_SABESP = "https://sabesp-api.herokuapp.com";

    public List<Reservoir> getReservoirs(State state) {
        List<Reservoir> reservoirs = new ArrayList<>();
        switch (state){
            case SP:
                try {
                    URL url = new URL(API_SABESP);
                    final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        throw new RuntimeException("Error code: " + conn.getResponseCode());
                    }
                    final ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Reservoir.class);
                    reservoirs = objectMapper.readValue(conn.getInputStream(), collectionType);
                    conn.disconnect();
                } catch (Exception e) {
                    throw new BusinessException(e);
                }
                break;
            default:
                throw new BusinessException(R.string.msg_state_nodata);
        }
        return reservoirs;
    }

    /**
     * Private singleton constructor.
     */
    private HttpService(){
        super();
    }

    /**
     * Lazy holder for singleton with Bill Pugh's solution.
     */
    private static class LazyHolder {
        private static final HttpService INSTANCE = new HttpService();
    }

    /**
     * get the {@link HttpService} singleton instance using Bill Pugh's solution.
     *
     * @return {@link HttpService} instance.
     */
    public static HttpService getInstance(){
        return LazyHolder.INSTANCE;
    }
}
