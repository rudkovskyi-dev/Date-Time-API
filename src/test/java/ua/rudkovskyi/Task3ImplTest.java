package ua.rudkovskyi;

import org.junit.jupiter.api.*;
import ua.rudkovskyi.datetimeapiimpl.Task3Impl;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Task3ImplTest {

    private final Task3Impl instance = new Task3Impl();

    @Test
    @Order(0)
    @DisplayName("Correct values of birthday (01.01.1991) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays1() {
        LocalDate birthday = LocalDate.of(1991, Month.JANUARY, 1);

        List<Year> valuesList = new ArrayList<>();
        String values = "1994, 2000, 2005, 2011";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(1)
    @DisplayName("Correct values of birthday (02.02.1992) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays2() {
        LocalDate birthday = LocalDate.of(1992, Month.FEBRUARY, 2);

        List<Year> valuesList = new ArrayList<>();
        String values = "2002, 2008, 2013, 2019";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(2)
    @DisplayName("Correct values of birthday (03.03.1993) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays3() {
        LocalDate birthday = LocalDate.of(1993, Month.MARCH, 3);

        List<Year> valuesList = new ArrayList<>();
        String values = "2001, 2007, 2012, 2018";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(3)
    @DisplayName("Correct values of birthday (04.04.1994) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays4() {
        LocalDate birthday = LocalDate.of(1994, Month.APRIL, 4);

        List<Year> valuesList = new ArrayList<>();
        String values = "1998, 2009, 2015, 2020";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(4)
    @DisplayName("Correct values of birthday (05.05.1995) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays5() {
        LocalDate birthday = LocalDate.of(1995, Month.MAY, 5);

        List<Year> valuesList = new ArrayList<>();
        String values = "2001, 2007, 2012, 2018";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(5)
    @DisplayName("Correct values of birthday (06.06.1996) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays6() {
        LocalDate birthday = LocalDate.of(1996, Month.JUNE, 6);

        List<Year> valuesList = new ArrayList<>();
        String values = "1998, 2009, 2015, 2020";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(6)
    @DisplayName("Correct values of birthday (07.07.1997) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays7() {
        LocalDate birthday = LocalDate.of(1997, Month.JULY, 7);

        List<Year> valuesList = new ArrayList<>();
        String values = "2001, 2007, 2012, 2018";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(7)
    @DisplayName("Correct values of birthday (08.08.1998) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays8() {
        LocalDate birthday = LocalDate.of(1998, Month.AUGUST, 8);

        List<Year> valuesList = new ArrayList<>();
        String values = "1998, 2009, 2015, 2020";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(8)
    @DisplayName("Correct values of birthday (09.09.1999) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays9() {
        LocalDate birthday = LocalDate.of(1999, Month.SEPTEMBER, 9);

        List<Year> valuesList = new ArrayList<>();
        String values = "2000, 2006, 2017";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(9)
    @DisplayName("Correct values of birthday (10.10.2000) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays10() {
        LocalDate birthday = LocalDate.of(2000, Month.OCTOBER, 10);

        List<Year> valuesList = new ArrayList<>();
        String values = "2009, 2015, 2020";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(10)
    @DisplayName("Correct values of birthday (11.11.2001) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays11() {
        LocalDate birthday = LocalDate.of(2001, Month.NOVEMBER, 11);

        List<Year> valuesList = new ArrayList<>();
        String values = "2006, 2017";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(11)
    @DisplayName("Correct values of birthday (12.12.2002) on Saturday till 02.02.2020 update may be required")
    void birthdaysOnSaturdays12() {
        LocalDate birthday = LocalDate.of(2002, Month.DECEMBER, 12);

        List<Year> valuesList = new ArrayList<>();
        String values = "2009, 2015, 2020";
        String[] valuesSplit = values.split(", ");
        for (String value : valuesSplit) {
            valuesList.add(Year.parse(value));
        }
        Assertions.assertEquals(valuesList, instance.birthdaysOnSaturdays(birthday));
    }

    @Test
    @Order(12)
    @DisplayName("[LOGIC] Correct values of birthdays (01.01.1991 - 12.12.2002) on Saturday till today, however, logic is present in order to be up to date")
    void birthdaysOnSaturdaysLogic() {
        for (int i = 0; i < 12; i++){
            LocalDate birthday = LocalDate.of(1991 + i, Month.JANUARY.getValue() + i, 1 + i);
            Assertions.assertEquals(birthdaysOnSaturdaysLogicUtil(birthday), instance.birthdaysOnSaturdays(birthday));
        }
    }

    private List<Year> birthdaysOnSaturdaysLogicUtil(LocalDate birthday) {
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