package com.fabriciomoreira.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    private DateUtils victim;

    @DisplayName("Should validate if the dates are the same day.")
    @ParameterizedTest
    @MethodSource("dateArguments")
    void testIsSameDay(Date date1, Date date2, boolean expected) {
        boolean result = DateUtils.isSameDay(date1, date2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> dateArguments() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);

        Calendar tomorrowCal = (Calendar) cal.clone();
        tomorrowCal.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = tomorrowCal.getTime();

        Calendar nextMonthCal = (Calendar) cal.clone();
        nextMonthCal.add(Calendar.MONTH, 1);
        Date nextMonth = nextMonthCal.getTime();

        return Stream.of(
                Arguments.of(today, today, true),
                Arguments.of(today, tomorrow, false),
                Arguments.of(today, nextMonth, false)
        );
    }

    @ParameterizedTest
    @MethodSource("calendarArguments")
    public void testIsSameDay(Calendar cal1, Calendar cal2, boolean expected) {
        boolean result = DateUtils.isSameDay(cal1, cal2);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> calendarArguments() {
        Calendar today = Calendar.getInstance();
        Calendar tomorrow = (Calendar) today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1);

        Calendar nextMonth = (Calendar) today.clone();
        nextMonth.add(Calendar.MONTH, 1);

        return Stream.of(
                Arguments.of(today, today, true),
                Arguments.of(today, tomorrow, false),
                Arguments.of(today, nextMonth, false)
        );
    }

    @Nested
    class IsTodayDateTest {
        @ParameterizedTest
        @MethodSource("dateArguments")
        public void testIsToday(Date date, boolean expected) {
            boolean result = DateUtils.isToday(date);
            Assertions.assertEquals(expected, result);
        }

        private static Stream<Arguments> dateArguments() {
            Date today = new Date();
            Date tomorrow = addDays(today, 1);
            Date nextMonth = addMonths(today, 1);

            return Stream.of(
                    Arguments.of(today, true),
                    Arguments.of(tomorrow, false),
                    Arguments.of(nextMonth, false)
            );
        }

        private static Date addDays(Date date, int days) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            return calendar.getTime();
        }

        private static Date addMonths(Date date, int months) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            return calendar.getTime();
        }
    }

    @Nested
    class IsTodayCalendarTest {
        @ParameterizedTest
        @MethodSource("calendarArguments")
        public void testIsToday(Calendar cal, boolean expected) {
            boolean result = DateUtils.isToday(cal);
            Assertions.assertEquals(expected, result);
        }

        private static Stream<Arguments> calendarArguments() {
            Calendar today = Calendar.getInstance();
            Calendar tomorrow = (Calendar) today.clone();
            tomorrow.add(Calendar.DAY_OF_MONTH, 1);
            Calendar nextMonth = (Calendar) today.clone();
            nextMonth.add(Calendar.MONTH, 1);

            return Stream.of(
                    Arguments.of(today, true),
                    Arguments.of(tomorrow, false),
                    Arguments.of(nextMonth, false)
            );
        }
    }

    @Nested
    class IsBeforeDayTest {
        @ParameterizedTest
        @MethodSource("dateArguments")
        void testIsBeforeDay(Date date1, Date date2, boolean expected) {
            boolean result = DateUtils.isBeforeDay(date1, date2);
            Assertions.assertEquals(expected, result);
        }

        private static Stream<Arguments> dateArguments() {
            Date today = new Date();
            Date tomorrow = addDays(today, 1);
            Date nextMonth = addMonths(today, 1);

            return Stream.of(
                    Arguments.of(today, tomorrow, true),
                    Arguments.of(tomorrow, today, false),
                    Arguments.of(today, nextMonth, true),
                    Arguments.of(nextMonth, today, false)
            );
        }

        private static Date addDays(Date date, int days) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            return calendar.getTime();
        }

        private static Date addMonths(Date date, int months) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            return calendar.getTime();
        }
    }


}