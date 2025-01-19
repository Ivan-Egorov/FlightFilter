package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * The class processes an incoming set of flights according to a set of filters.
 * Inappropriate options are output to the console with a message indicating reason.
 */
class FlightFilter {

    static List<Flight> filterAll(List<Flight> flightList, List<Filter> filterList) {
        if (flightList == null) {
            return null;
        } else if (filterList == null) {
            return flightList;
        }

        List<Flight> sorted = new ArrayList<>(flightList);
        List<Flight> removed = new ArrayList<>();

        for (Filter filter : filterList) {
            removed.addAll(sorted.stream().filter(filter::test).toList());

            if (!removed.isEmpty()) {
                System.out.printf("Flights excluded from the list due to:\t%s\n", filter.getMessage());
                removed.forEach(System.out::println);
                sorted.removeAll(removed);
                removed.clear();
            }
        }

        return sorted;
    }
}
