package ua.rudkovskyi.datetimeapiimpl;

import ua.rudkovskyi.datetimeapi.Task4;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4Impl implements Task4 {
    @Override
    public List<MonthDay> daysNotWith24Hours(Year year) {
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
