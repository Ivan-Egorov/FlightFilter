package com.gridnine.testing;

/**
 * Filter: there are segments with an arrival time before the departure time.
 */
public class Filter2 implements Filter{

    @Override
    public boolean test(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getMessage() {
        return "there are segments with an arrival time before the departure time";
    }
}
