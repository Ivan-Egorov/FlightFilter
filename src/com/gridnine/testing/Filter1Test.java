package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Filter1Test {

    @Test
    void filter1Check() {
        Segment segment1 = new Segment(LocalDateTime.now().minusHours(2), LocalDateTime.now().plusHours(5));
        Flight flight1 = new Flight(List.of(segment1));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(5));
        Flight flight2 = new Flight(List.of(segment2));
        assertAll(
                () -> assertTrue(new Filter1().test(flight1)),
                () -> assertFalse(new Filter1().test(flight2))
        );
    }
}