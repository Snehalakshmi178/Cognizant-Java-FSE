// src/test/java/com/example/MyServiceTest.java
package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals; // For assertions
import static org.mockito.Mockito.*; // For Mockito static methods like mock() and when()

import org.junit.jupiter.api.Test;
import org.mockito.Mockito; // Can also use this for Mockito.mock()

/**
 * Test class for MyService, demonstrating how to use Mockito to mock an
 * external API dependency.
 */
public class MyServiceTest {

    /**
     * This test method demonstrates mocking an external API to control its
     * behavior during the test.
     *
     * Steps:
     * 1. Create a mock object for the ExternalApi using Mockito.mock().
     * 2. Stub the getData() method of the mock to return a predefined value ("Mock Data").
     * This ensures that when MyService calls getData(), it receives our controlled data
     * instead of making a real external call.
     * 3. Create an instance of MyService, injecting the mockApi.
     * 4. Call the method under test (fetchData()) on MyService.
     * 5. Assert that the result matches the predefined value returned by the mock.
     * 6. (Optional but good practice) Verify that the mock's method was called as expected.
     */
    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for the External API.
        // Mockito will create a proxy object that behaves like ExternalApi,
        // but we can control its method calls.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub the methods to return predefined values.
        // When mockApi.getData() is called, it will return "Mock Data".
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Write a test case that uses the mock object.
        // Create an instance of MyService, injecting the mock object.
        MyService service = new MyService(mockApi);

        // Call the method on MyService that uses the external API.
        String result = service.fetchData();

        // Assert that the result is as expected, based on our stubbed data.
        assertEquals("Mock Data", result, "The service should return the mock data.");

        // Optional: Verify that the getData() method on the mock was actually called once.
        // This confirms that MyService interacted with its dependency as expected.
        verify(mockApi, times(1)).getData();
    }
}
