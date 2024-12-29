package com.gridnine.testing;

import java.util.List;

public class FilterExecutor {

    public List<Flight>executeAllFilters(List <FlightFilter> filterList, List<Flight> flightList) {
        for (FlightFilter filter : filterList) {
            flightList = filter.execute(flightList);
        }
        return flightList;
    }
}
