package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The class processes an incoming set of filters.
 * Inappropriate options are output to the console with a message indicating reason.
 */
class FilterAll {

    static List<Flight> filter(List<Flight> flightList, List<Filter> filterList) {
        if (flightList == null) {
            return new ArrayList<>();
        } else if (filterList == null) {
            return flightList;
        }

        List<Flight> sorted = new ArrayList<>(flightList.stream().filter(Objects::nonNull).toList());
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
