package com.gridnine.testing;

import java.util.List;

/**
 * Main class creates sample set of filters and launches the filtering process.
 */
public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        List<Filter> filterList = List.of(new Filter1(),
                                          new Filter2(),
                                          new Filter3());

        List<Flight> suitable = FlightFilter.filterAll(flightList, filterList);
        System.out.println("Suitable flight options:");
        suitable.forEach(System.out::println);
    }
}
