package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightAllTest {
    List<Flight> flightList = FlightBuilder.createFlights();
    List<Filter> filterList = List.of(new Filter1(),
                                      new Filter2(),
                                      new Filter3());

    @Test
    public void emptyTest() {
        assertTrue(FilterAll.filter(new ArrayList<>(), new ArrayList<>()).isEmpty());
    }

    @Test
    public void nullFlightTest() {
        List<Flight> nullList = new ArrayList<>();
        nullList.add(null);
        assertTrue(FilterAll.filter(nullList, filterList).isEmpty());
    }

    @Test
    public void nullFlightListTest() {
        assertTrue(FilterAll.filter(null, filterList).isEmpty());
    }

    @Test
    public void nullFilterListTest() {
        assertEquals(FilterAll.filter(flightList, null), flightList);
    }
}
