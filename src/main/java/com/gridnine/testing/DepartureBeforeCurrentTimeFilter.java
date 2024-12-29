package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DepartureBeforeCurrentTimeFilter implements FlightFilter {

    private LocalDateTime currentTime;

    public DepartureBeforeCurrentTimeFilter() {
        this.currentTime = LocalDateTime.now();
    }

    @Override
    public List<Flight> execute (List<Flight> flightList) {
        if (flightList == null || flightList.isEmpty()) return Collections.emptyList();
        return flightList.stream()
                .filter(f -> f.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isAfter(currentTime)))
                .collect(toList());
    }
}
