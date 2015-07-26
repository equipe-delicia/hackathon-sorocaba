package com.ciandt.hackathon.sorocaba.http;

import com.ciandt.hackathon.sorocaba.entity.Marker;

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

    public List<Marker> getMarkes() {
        /*List<Marker> marker = new ArrayList<>();

        try {
            URL url = new URL(API_APP);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Error code: " + conn.getResponseCode());
            }
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Marker.class);
            marker = objectMapper.readValue(conn.getInputStream(), collectionType);
            conn.disconnect();
        } catch (Exception e) {
            throw new BusinessException(e);
        }

        return marker;*/

        /* MOK for testing. Remove after the test! */
        return mock();
    }

    /**
     * Private singleton constructor.
     */
    private HttpService() {
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
    public static HttpService getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* MOK for testing. Remove after the test! */
    public List<Marker> mock() {
        List<Marker> marker = new ArrayList<>();

        final Marker cityAraraquara = new Marker();
        cityAraraquara.setName("Araraquara");
        cityAraraquara.setAverage(50.0);
        cityAraraquara.setCurrentvalue(25.0);
        cityAraraquara.setLat("-21° 47' 40''");
        cityAraraquara.setLon("-48° 10' 32''");
        marker.add(cityAraraquara);

        final Marker citySorocaba = new Marker();
        citySorocaba.setName("Sorocaba");
        citySorocaba.setAverage(50.0);
        citySorocaba.setCurrentvalue(50.0);
        citySorocaba.setLat("-23° 30' 06''");
        citySorocaba.setLon("-47° 27' 29''");
        marker.add(citySorocaba);

        final Marker citySaoPaulo = new Marker();
        citySaoPaulo.setName("São Paulo");
        citySaoPaulo.setAverage(50.0);
        citySaoPaulo.setCurrentvalue(75.0);
        citySaoPaulo.setLat("-23° 32' 51''");
        citySaoPaulo.setLon("-46° 38' 10''");
        marker.add(citySaoPaulo);

        return marker;
    }
}
