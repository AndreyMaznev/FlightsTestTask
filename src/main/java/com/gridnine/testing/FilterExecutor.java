package com.gridnine.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterExecutor {

    public List<Flight>executeAllFilters(List <FlightFilter> filterList, List<Flight> flightList) {
        if (filterList == null || filterList.isEmpty()) {
            return flightList;
        }
        for (FlightFilter filter : filterList) {
            flightList = filter.execute(flightList);
        }
        return flightList;
    }
}
