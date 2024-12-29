package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterExecutorTest {
    LocalDateTime currentTime = LocalDateTime.of(2024,12,30,12,0);
    FilterExecutor filterExecutor = new FilterExecutor();
    DepartureBeforeCurrentTimeFilter beforeCurrentTimeFilterTest = new DepartureBeforeCurrentTimeFilter(currentTime);
    DepartureBeforeArrivalFilter beforeArrivalFilterTest = new DepartureBeforeArrivalFilter();
    TwoHoursOnTheGroundFilter twoHoursOnTheGroundFilterTest = new TwoHoursOnTheGroundFilter();


    Segment testSegmentOne = new Segment(LocalDateTime.of(2024,12,29,3,30)
            , LocalDateTime.of(2024,12,29,12,0));

    Segment testSegmentTwo = new Segment(LocalDateTime.of(2024,12,29,13,0)
            , LocalDateTime.of(2024,12,29,15,30));

    Segment testSegmentThree = new Segment(LocalDateTime.of(2024,12,29,18,0)
            , LocalDateTime.of(2024,12,30,3,30));

    Segment testSegmentFour = new Segment(LocalDateTime.of(2024,12,30,6,30)
            , LocalDateTime.of(2025,1,1,3,30));

    Segment testSegmentFive = new Segment(LocalDateTime.of(2024,12,30,13,30)
            , LocalDateTime.of(2024,12,30,15,30));

    Segment testSegmentSix = new Segment(LocalDateTime.of(2024,12,30,16,0)
            , LocalDateTime.of(2025,1,1,3,30));

    Flight testFlightOne = new Flight(List.of(testSegmentOne));
    Flight testFlightTwo = new Flight(List.of(testSegmentOne, testSegmentTwo));
    Flight testFlightThree = new Flight(List.of(testSegmentOne, testSegmentTwo,testSegmentThree));
    Flight testFlightFour = new Flight(List.of(testSegmentThree,testSegmentFour));
    Flight testFlightFive = new Flight(List.of(testSegmentFive,testSegmentSix));

    List <FlightFilter> flightFilterList = new ArrayList<>(List.of(
            beforeCurrentTimeFilterTest,
            beforeArrivalFilterTest,
            twoHoursOnTheGroundFilterTest));

    List <Flight> expectedFlightList = new ArrayList<>(List.of(testFlightFive));

    @Test
    void executeAllFilters () {
        assertEquals(
                filterExecutor.executeAllFilters(flightFilterList,List.of(testFlightOne,testFlightTwo,testFlightThree,testFlightFour,testFlightFive)),
                expectedFlightList);
    }

}