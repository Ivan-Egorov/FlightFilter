package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightFilterTest {
    List<Flight> flightList = FlightBuilder.createFlights();
    List<Filter> filterList = List.of(new Filter1(),
                                      new Filter2(),
                                      new Filter3());

    @Test
    public void emptyTest() {
        assertTrue(FlightFilter.filterAll(new ArrayList<>(), new ArrayList<>()).isEmpty());
    }

    @Test
    public void nullFlightTest() {
        List<Flight> nullList = new ArrayList<>();
        nullList.add(null);
        assertTrue(FlightFilter.filterAll(nullList, filterList).isEmpty());
    }

    @Test
    public void nullFlightListTest() {
        assertTrue(FlightFilter.filterAll(null, filterList).isEmpty());
    }

    @Test
    public void nullFilterListTest() {
        assertEquals(FlightFilter.filterAll(flightList, null), flightList);
    }
}
