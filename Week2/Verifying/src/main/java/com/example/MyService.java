// src/main/java/com/example/MyService.java
package com.example;

/**
 * A service that depends on an external API to fetch data.
 */
public class MyService {

    private final ExternalApi externalApi;

    /**
     * Constructor for MyService.
     *
     * @param externalApi The external API dependency.
     */
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data using the external API.
     * This method contains the business logic that we want to test.
     *
     * @return The data fetched from the external API.
     */
    public String fetchData() {
        // In a real application, there might be more complex logic here
        // involving processing the data from externalApi.getData()
        return externalApi.getData();
    }
}
