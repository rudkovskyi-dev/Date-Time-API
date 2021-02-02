package ua.rudkovskyi.datetimeapiimpl;

import ua.rudkovskyi.datetimeapi.Task5;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5Impl implements Task5 {
    @Override
    public List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones) {
        List<ZoneId> zonesAlwaysClockShift = new ArrayList<>();

        zones.stream().forEach(z -> {
            List<Boolean> values = areDaysNotWith24HoursInTimeZone(TimeZone.getTimeZone(z));
            if (values.size() == 1 && values.get(0)){
                zonesAlwaysClockShift.add(z);
            }});

        return zonesAlwaysClockShift;
    }

    @Override
    public List<ZoneId> zonesNeverClockShift(List<ZoneId> zones) {
        List<ZoneId> zonesNeverClockShift = new ArrayList<>();

        zones.stream().forEach(z -> {
            List<Boolean> values = areDaysNotWith24HoursInTimeZone(TimeZone.getTimeZone(z));
            if (values.size() == 1 && !values.get(0)){
                zonesNeverClockShift.add(z);
            }});

        return zonesNeverClockShift;
    }

    @Override
    public List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones) {
        List<ZoneId> zonesChangedClockShiftRules = new ArrayList<>();

        zones.stream().forEach(z -> {
            List<Boolean> values = areDaysNotWith24HoursInTimeZone(TimeZone.getTimeZone(z));
            if (values.size() == 2){
                zonesChangedClockShiftRules.add(z);
            }});

        return zonesChangedClockShiftRules;
    }

    private List<Boolean> areDaysNotWith24HoursInTimeZone(TimeZone tz) {
        ZonedDateTime timeStart = LocalDateTime.now()
                .withYear(1900)
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        ZonedDateTime timeEnd = LocalDateTime.now()
                .truncatedTo(ChronoUnit.SECONDS)
                .atZone(tz.toZoneId());

        return Stream.iterate(timeStart, c -> c.plusYears(1))
                .parallel()
                .limit(ChronoUnit.YEARS.between(timeStart, timeEnd) + 1)
                .map(c -> areDaysNotWith24Hours(c.getYear(), tz))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private boolean areDaysNotWith24Hours(int year, TimeZone tz) {
        ZonedDateTime timeStart = LocalDateTime.now()
                .withYear(year)
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        ZonedDateTime timeEnd = LocalDateTime.now()
                .withYear(year + 1)
                .withMonth(Month.JANUARY.getValue())
                .withDayOfMonth(1)
                .truncatedTo(ChronoUnit.DAYS)
                .atZone(tz.toZoneId());

        long counter = Stream.iterate(timeStart, c -> c.plusDays(1))
                .limit(ChronoUnit.DAYS.between(timeStart, timeEnd))
                .filter(c -> ChronoUnit.HOURS.between(
                        c.toLocalDate().atStartOfDay(tz.toZoneId()),
                        c.toLocalDate().plusDays(1).atStartOfDay(tz.toZoneId()))
                        != 24)
                .map(c -> MonthDay.from(c.toLocalDate()))
                .count();

        return counter > 0;
    }
}
