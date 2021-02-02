package ua.rudkovskyi;

import org.junit.jupiter.api.*;
import ua.rudkovskyi.datetimeapiimpl.Task4Impl;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Task4ImplTest {

    private final Task4Impl instance = new Task4Impl();

    @Test
    @Order(0)
    @DisplayName("Correct values of time shifts (1919) for Europe/Kiev")
    void daysNotWith24Hours1919() {
        Year year = Year.of(1919);
        List<MonthDay> valuesList = new ArrayList<>();
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(1)
    @DisplayName("Correct values of time shifts (1930) for Europe/Kiev")
    void daysNotWith24Hours1930() {
        Year year = Year.of(1930);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--06-21";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(2)
    @DisplayName("Correct values of time shifts (1940) for Europe/Kiev")
    void daysNotWith24Hours1940() {
        Year year = Year.of(1940);
        List<MonthDay> valuesList = new ArrayList<>();
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(3)
    @DisplayName("Correct values of time shifts (1941) for Europe/Kiev")
    void daysNotWith24Hours1941() {
        Year year = Year.of(1941);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--09-19";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }


    @Test
    @Order(4)
    @DisplayName("Correct values of time shifts (1942) for Europe/Kiev")
    void daysNotWith24Hours1942() {
        Year year = Year.of(1942);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--11-02";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }


    @Test
    @Order(5)
    @DisplayName("Correct values of time shifts (1943) for Europe/Kiev")
    void daysNotWith24Hours1943() {
        Year year = Year.of(1943);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--03-29, --10-04, --11-06";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(6)
    @DisplayName("Correct values of time shifts (1944) for Europe/Kiev")
    void daysNotWith24Hours1944() {
        Year year = Year.of(1944);
        List<MonthDay> valuesList = new ArrayList<>();
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(7)
    @DisplayName("Correct values of time shifts (1980) for Europe/Kiev")
    void daysNotWith24Hours1980() {
        Year year = Year.of(1980);
        List<MonthDay> valuesList = new ArrayList<>();
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(7)
    @DisplayName("Correct values of time shifts (1981) for Europe/Kiev")
    void daysNotWith24Hours1981() {
        Year year = Year.of(1981);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--04-01, --09-30";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(8)
    @DisplayName("Correct values of time shifts (1991) for Europe/Kiev")
    void daysNotWith24Hours1991() {
        Year year = Year.of(1991);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--09-29";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(9)
    @DisplayName("Correct values of time shifts (2020) for Europe/Kiev")
    void daysNotWith24Hours2020() {
        Year year = Year.of(2020);
        List<MonthDay> valuesList = new ArrayList<>();
        String values = "--03-29, --10-25";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(MonthDay.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
    }

    @Test
    @Order(10)
    @DisplayName("[LOGIC] Correct values of time shifts (1900-2020) for Europe/Kiev")
    void daysNotWith24HoursLogic() {
        for (int i = 0; i < 120; i++) {
            Year year = Year.of(1900 + i);
            List<MonthDay> valuesList = daysNotWith24HoursLogicUtil(year);
            Assertions.assertEquals(valuesList, instance.daysNotWith24Hours(year));
        }
    }

    public List<MonthDay> daysNotWith24HoursLogicUtil(Year year) {
        TimeZone tz = TimeZone.getTimeZone("Europe/Kiev");

        ZonedDateTime timeStart = LocalDateTime.now()
                .withYear(year.getValue())
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        ZonedDateTime timeEnd = LocalDateTime.now()
                .withYear(year.getValue() + 1)
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        return Stream.iterate(timeStart, c -> c.plusDays(1))
                .limit(ChronoUnit.DAYS.between(timeStart, timeEnd) + 1)
                .filter(c -> ChronoUnit.HOURS.between(
                        c.toLocalDate().atStartOfDay(tz.toZoneId()),
                        c.toLocalDate().plusDays(1).atStartOfDay(tz.toZoneId()))
                        != 24)
                .map(c -> MonthDay.from(c.toLocalDate()))
                .collect(Collectors.toList());
    }
}