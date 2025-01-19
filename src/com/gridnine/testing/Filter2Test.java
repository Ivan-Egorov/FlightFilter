package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Filter2Test {

    @Test
    void filter2Check() {
        Segment segment1 = new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(3));
        Flight flight1 = new Flight(List.of(segment1));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(6));
        Flight flight2 = new Flight(List.of(segment2));
        assertAll(
                () -> assertTrue(new Filter2().test(flight1)),
                () -> assertFalse(new Filter2().test(flight2))
        );
    }
}