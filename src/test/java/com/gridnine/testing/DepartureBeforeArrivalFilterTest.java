package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartureBeforeArrivalFilterTest {
    DepartureBeforeArrivalFilter filter = new DepartureBeforeArrivalFilter();

    Segment testSegmentOne = new Segment(LocalDateTime.of(2024,12,29,3,30)
            , LocalDateTime.of(2024,12,29,12,30));

    Segment testSegmentTwo = new Segment(LocalDateTime.of(2024,12,29,12,30)
            , LocalDateTime.of(2024,12,29,3,30));

    Segment testSegmentThree = new Segment(LocalDateTime.of(2024,12,30,12,30)
            , LocalDateTime.of(2024,12,28,3,30));


    Flight testFlightOne = new Flight(List.of(testSegmentOne));
    Flight testFlightTwo = new Flight(List.of(testSegmentOne, testSegmentTwo));
    Flight testFlightThree = new Flight(List.of(testSegmentOne, testSegmentTwo,testSegmentThree));

    List <Flight> expectedFilteredFlightsList  = new ArrayList<>(List.of(testFlightOne));

    @Test
    void executeReturnsRightFlightsList() {
        assertEquals (filter.execute(Arrays.asList(testFlightOne,testFlightTwo)), expectedFilteredFlightsList);
        assertEquals (filter.execute(Arrays.asList(testFlightOne,testFlightTwo,testFlightThree)), expectedFilteredFlightsList);
    }

    @Test
    void executeReturnsEmptyListIfInputListIsNullOrEmpty() {
        List <Flight> nullList = null;
        assertEquals(filter.execute(nullList), List.of());
        List <Flight> emptyList = new ArrayList<>();
        assertEquals(filter.execute(emptyList), List.of());
    }



}