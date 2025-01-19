package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Filter: the total layover time exceeds two hours.
 */
public class Filter3 implements Filter{

    @Override
    public boolean test(Flight flight) {
        LocalDateTime pastArrival = null;
        Duration layover = Duration.ZERO;

        for (Segment segment : flight.getSegments()) {
            if (pastArrival != null) {
                layover = layover.plus(Duration.between(pastArrival, segment.getDepartureDate()));
            }

            if (layover.compareTo(Duration.ofHours(2)) > 0) {
                return true;
            }
            pastArrival = segment.getArrivalDate();
        }
        return false;
    }

    @Override
    public String getMessage() {
        return "the total layover time exceeds two hours";
    }
}