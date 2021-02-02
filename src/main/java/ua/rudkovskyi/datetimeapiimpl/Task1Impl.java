package ua.rudkovskyi.datetimeapiimpl;

import ua.rudkovskyi.datetimeapi.Task1;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1Impl implements Task1 {
    @Override
    public List<String> fridays13() {
        TimeZone tz = TimeZone.getTimeZone("UTC");

        DateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

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
                .filter(c -> DayOfWeek.FRIDAY.equals(c.getDayOfWeek()))
                .filter(c -> 13 == c.getDayOfMonth())
                .map(c -> dateFormat.format(Date.from(c.toInstant())))
                .collect(Collectors.toList());
    }
}
