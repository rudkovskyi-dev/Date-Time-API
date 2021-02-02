package ua.rudkovskyi;

import org.junit.jupiter.api.*;
import ua.rudkovskyi.datetimeapiimpl.Task1Impl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Task1ImplTest {

    private final Task1Impl instance = new Task1Impl();

    @Test
    @Order(0)
    @DisplayName("Correct values of friday 13 till 02.02.2020 update may be required")
    void fridays13() {
        List<String> valuesList = new ArrayList<>();
        String values = "Oct 2000, Apr 2001, Jul 2001, Sep 2002, Dec 2002, Jun 2003, Feb 2004, Aug 2004, May 2005, Jan 2006, Oct 2006, Apr 2007, Jul 2007, Jun 2008, Feb 2009, Mar 2009, Nov 2009, Aug 2010, May 2011, Jan 2012, Apr 2012, Jul 2012, Sep 2013, Dec 2013, Jun 2014, Feb 2015, Mar 2015, Nov 2015, May 2016, Jan 2017, Oct 2017, Apr 2018, Jul 2018, Sep 2019, Dec 2019, Mar 2020, Nov 2020";
        String[] valuesSplit = values.split(", ");
        valuesList = Arrays.asList(valuesSplit);
        Assertions.assertEquals(valuesList, instance.fridays13());
    }

    @Test
    @Order(1)
    @DisplayName("[LOGIC] Correct values of friday 13 till today, however, logic is present in order to be up to date")
    void friday13Logic() {
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

        Assertions.assertEquals(Stream.iterate(timeStart, c -> c.plusDays(1))
                        .limit(ChronoUnit.DAYS.between(timeStart, timeEnd) + 1)
                        .filter(c -> DayOfWeek.FRIDAY.equals(c.getDayOfWeek()))
                        .filter(c -> 13 == c.getDayOfMonth())
                        .map(c -> dateFormat.format(Date.from(c.toInstant())))
                        .collect(Collectors.toList()),
                instance.fridays13());
    }
}

