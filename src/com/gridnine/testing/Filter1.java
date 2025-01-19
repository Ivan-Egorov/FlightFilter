package com.gridnine.testing;

import java.time.LocalDateTime;

/**
 * Filter: departure before the current time.
 */
public class Filter1 implements Filter{

    @Override
    public boolean test(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getMessage() {
        return "departure before the current time";
    }
}
