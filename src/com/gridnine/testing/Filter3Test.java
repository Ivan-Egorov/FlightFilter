package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Filter3Test {

    @Test
    void filter3Check() {
        Segment segment1 = new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(4));
        Flight flight1 = new Flight(List.of(segment1));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(8));
        Flight flight2 = new Flight(List.of(segment1, segment2));
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(12), LocalDateTime.now().plusHours(13));
        Flight flight3 = new Flight(List.of(segment1, segment2, segment3));
        assertAll(
                () -> assertFalse(new Filter3().test(flight1)),
                () -> assertFalse(new Filter3().test(flight2)),
                () -> assertTrue(new Filter3().test(flight3))
        );
    }
}