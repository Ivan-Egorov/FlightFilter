package com.gridnine.testing;

import java.util.*;
import java.util.function.Predicate;

/**
 * A filter, using an incoming set of conditions.
 * Inappropriate options are output to the console with a message, indicating reason.
 */
class FlightFilter {
    static List<Flight> filter(List<Flight> flightList, Map<String, Predicate<Flight>> filters) {
        List<Flight> sorted = new ArrayList<>(flightList);
        List<Flight> remove = new ArrayList<>();
        List<Flight> printMessage = new ArrayList<>();
        Set<String> filterNames = filters.keySet();
        Predicate<Flight> predicate;

        for (String filterName : filterNames) {
            predicate = filters.get(filterName);

            for (Flight flight : sorted) {
                if (!remove.contains(flight) && predicate.test(flight)) {
                    remove.add(flight);
                    printMessage.add(flight);
                }
            }

            if (!printMessage.isEmpty()) {
                System.out.printf("Flights excluded from the list due to:\t%s\n", filterName);
                printMessage.forEach(System.out::println);
            }

            printMessage.clear();
        }

        sorted.removeAll(remove);
        return sorted;
    }
}
