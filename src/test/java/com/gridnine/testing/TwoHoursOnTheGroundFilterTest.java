package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoHoursOnTheGroundFilterTest {
    TwoHoursOnTheGroundFilter filter = new TwoHoursOnTheGroundFilter();

    Segment testSegmentOne = new Segment(LocalDateTime.of(2024,12,29,3,30)
            , LocalDateTime.of(2024,12,29,12,0));

    Segment testSegmentTwo = new Segment(LocalDateTime.of(2024,12,29,13,0)
            , LocalDateTime.of(2024,12,29,15,30));

    Segment testSegmentThree = new Segment(LocalDateTime.of(2024,12,29,18,0)
            , LocalDateTime.of(2024,12,30,3,30));

    Segment testSegmentFour = new Segment(LocalDateTime.of(2024,12,30,6,30)
            , LocalDateTime.of(2025,1,1,3,30));


    Flight testFlightOne = new Flight(List.of(testSegmentOne));
    Flight testFlightTwo = new Flight(List.of(testSegmentOne, testSegmentTwo));
    Flight testFlightThree = new Flight(List.of(testSegmentOne, testSegmentTwo,testSegmentThree));
    Flight testFlightFour = new Flight(List.of(testSegmentThree,testSegmentFour));

    List <Flight> expectedFilteredFlightsList  = new ArrayList<>(List.of(testFlightOne,testFlightTwo));

    @Test
    void execute() {
        assertEquals (filter.execute(Arrays.asList(testFlightOne,testFlightTwo,testFlightThree,testFlightFour))
                , expectedFilteredFlightsList);
    }

}