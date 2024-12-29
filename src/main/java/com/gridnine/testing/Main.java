package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FilterExecutor executor = new FilterExecutor();
        List <Flight> flightList = FlightBuilder.createFlights();
        System.out.println("Отфильтрованные полёты, кроме тех, дата вылета которых раньше текущей даты: ");
        printAllTheFlightsFromList(executor.executeAllFilters(List.of(new DepartureBeforeCurrentTimeFilter(LocalDateTime.now())),flightList));
        System.out.println("Отфильтрованные полёты, кроме тех, сегменты которых содержат дату прилета раньше даты вылета: ");
        printAllTheFlightsFromList(executor.executeAllFilters(List.of(new DepartureBeforeArrivalFilter()),flightList));
        System.out.println("Отфильтрованные полёты, кроме тех, сегменты которых в сумме приводят к времени на земле более 2х часов : ");
        printAllTheFlightsFromList(executor.executeAllFilters(List.of(new TwoHoursOnTheGroundFilter()),flightList));

    /**
    Функционал модуля предусматривает фильтрацию всех полётов набором фильтров через FilterExecutor,
    который принимает на вход первым параметром List фильтров и вторым параметром List полётов.
    Таким образом реализовывая интерфейс FlightFilter можно создавать неограниченное количество пользовательских фильтров
    и вызывать их одной функцией класса FilterExecutor.

    Для тестирования раскомментировать код ниже.
    */

        List <FlightFilter> filters = new ArrayList<>();
        filters.add(new DepartureBeforeCurrentTimeFilter(LocalDateTime.now()));
        filters.add(new DepartureBeforeArrivalFilter());
        filters.add(new TwoHoursOnTheGroundFilter());
        System.out.println("Список полётов отфильтрованный по трём имеющимся фильтрам: ");
        printAllTheFlightsFromList(executor.executeAllFilters(filters,flightList));

    }

    public static void printAllTheFlightsFromList(List <Flight> flightList) {
        for (Flight flight : flightList) {
            System.out.println("Flight: " + flight);
        }
    }

}

