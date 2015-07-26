package com.ciandt.hackathon.sorocaba.http;

/**
 * Ticket singleton service for HTTP calls.
 *
 * @author falvojr
 */
public class HttpReservoirService {

    /**
     * Private singleton constructor.
     */
    private HttpReservoirService(){
        super();
    }

    /**
     * Lazy holder for singleton with Bill Pugh's solution.
     */
    private static class LazyHolder {
        private static final HttpReservoirService INSTANCE = new HttpReservoirService();
    }

    /**
     * get the {@link HttpReservoirService} singleton instance using Bill Pugh's solution.
     *
     * @return {@link HttpReservoirService} instance.
     */
    public static HttpReservoirService getInstance(){
        return LazyHolder.INSTANCE;
    }
}
