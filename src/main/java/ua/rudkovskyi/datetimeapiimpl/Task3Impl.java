package ua.rudkovskyi.datetimeapiimpl;

import ua.rudkovskyi.datetimeapi.Task3;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3Impl implements Task3 {
    @Override
    public List<Year> birthdaysOnSaturdays(LocalDate birthday) {
        TimeZone tz = TimeZone.getTimeZone("UTC");

        ZonedDateTime timeStart = LocalDateTime.now()
                .withYear(birthday.getYear())
                .withMonth(birthday.getMonthValue())
                .withDayOfMonth(birthday.getDayOfMonth())
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        ZonedDateTime timeEnd = LocalDateTime.now()
                .truncatedTo(ChronoUnit.SECONDS)
                .atZone(tz.toZoneId());

        return Stream.iterate(timeStart, c -> c.plusDays(1))
                .limit(ChronoUnit.DAYS.between(timeStart, timeEnd) + 1)
                .filter(c -> birthday.getMonthValue() == c.getMonthValue())
                .filter(c -> birthday.getDayOfMonth() == c.getDayOfMonth())
                .filter(c -> DayOfWeek.SATURDAY.equals(c.getDayOfWeek()))
                .map(c -> Year.from(c.toLocalDate()))
                .collect(Collectors.toList());
    }
}
