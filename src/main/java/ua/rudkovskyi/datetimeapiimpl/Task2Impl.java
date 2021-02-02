package ua.rudkovskyi.datetimeapiimpl;

import ua.rudkovskyi.datetimeapi.Task2;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2Impl implements Task2 {
    @Override
    public List<YearMonth> endOnSundays() {
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

        return Stream.iterate(timeStart, c -> c.plusDays(1))
                .limit(ChronoUnit.DAYS.between(timeStart, timeEnd) + 1)
                .filter(c -> DayOfWeek.SUNDAY.equals(c.getDayOfWeek()))
                .filter(c -> YearMonth.from(c.toLocalDate()).atEndOfMonth()
                        .getDayOfMonth() == c.getDayOfMonth())
                .map(c -> YearMonth.from(c.toLocalDate()))
                .collect(Collectors.toList());
    }
}
