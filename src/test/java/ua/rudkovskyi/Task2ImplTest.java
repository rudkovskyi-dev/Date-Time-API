package ua.rudkovskyi;

import org.junit.jupiter.api.*;
import ua.rudkovskyi.datetimeapiimpl.Task2Impl;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Task2ImplTest {

    private final Task2Impl instance = new Task2Impl();

    @Test
    @Order(0)
    @DisplayName("Correct values of months that end on Sunday till 02.02.2020 update may be required")
    void endOnSundays() {
        List<YearMonth> valuesList = new ArrayList<>();
        String values = "2000-04, 2000-12, 2001-09, 2002-03, 2002-06, 2003-08, 2003-11, 2004-02, 2004-10, 2005-07, 2006-04, 2006-12, 2007-09, 2008-08, 2008-11, 2009-05, 2010-01, 2010-02, 2010-10, 2011-07, 2012-09, 2013-03, 2013-06, 2014-08, 2014-11, 2015-05, 2016-01, 2016-07, 2017-04, 2017-12, 2018-09, 2019-03, 2019-06, 2020-05, 2021-01";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(YearMonth.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.endOnSundays());
    }

    @Test
    @Order(1)
    @DisplayName("[LOGIC] Correct values of months that end on Sunday till today, however, logic is present in order to be up to date")
    void endOnSundaysLogic() {
        TimeZone tz = TimeZone.getTimeZone("UTC");

        ZonedDateTime timeStart = LocalDateTime.now()
                .withYear(2000)
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        ZonedDateTime timeEnd = LocalDateTime.now()
                .truncatedTo(ChronoUnit.SECONDS)
                .atZone(tz.toZoneId());

        Assertions.assertEquals(Stream.iterate(timeStart, c -> c.plusDays(1))
                        .limit(ChronoUnit.DAYS.between(timeStart, timeEnd) + 1)
                        .filter(c -> DayOfWeek.SUNDAY.equals(c.getDayOfWeek()))
                        .filter(c -> YearMonth.from(c.toLocalDate()).atEndOfMonth()
                                .getDayOfMonth() == c.getDayOfMonth())
                        .map(c -> YearMonth.from(c.toLocalDate()))
                        .collect(Collectors.toList()),
                instance.endOnSundays());
    }
}