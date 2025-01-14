package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

/**
 * Main class, that creates sample set of filters and launches the filtering process.
 * The set contains messages explaining the meaning of each filter.
 */
public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        Map<String, Predicate<Flight>> filters = new LinkedHashMap<>();

        filters.put("departure before the current time", flight -> {
            for (Segment s : flight.getSegments()) {
                if (s.getDepartureDate().isBefore(LocalDateTime.now())) {
                    return true;
                }
            }
            return false;
        });

        filters.put("there are segments with an arrival time before the departure time", flight -> {
            for (Segment s : flight.getSegments()) {
                if (s.getArrivalDate().isBefore(s.getDepartureDate())) {
                    return true;
                }
            }
            return false;
        });

        filters.put("the total layover time exceeds two hours", flight -> {
            LocalDateTime pastArrival = null;
            Duration layover = Duration.ZERO;

            for (Segment s : flight.getSegments()) {
                if (pastArrival != null) {
                    layover = layover.plus(Duration.between(pastArrival, s.getDepartureDate()));
                }

                if (layover.compareTo(Duration.ofHours(2)) > 0) {
                    return true;
                }
                pastArrival = s.getArrivalDate();
            }
            return false;
        });

        List<Flight> result = FlightFilter.filter(flightList, filters);
        System.out.println("Suitable flight options:");
        result.forEach(System.out::println);
    }
}
