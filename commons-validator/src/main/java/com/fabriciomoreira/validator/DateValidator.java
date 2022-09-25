package com.fabriciomoreira.validator;

import java.time.LocalDate;

public class DateValidator {

    DateValidator() {

    }

    /**
     * Check if the date passed by parameter is greater than now.
     * @param date The date to be compared with the instant time (now).
     * @return true if the parameter is greater than Now().
     */
    public static boolean isGreaterThanNow(LocalDate date) {
        if (date == null) {
            return false;
        }
        return (date.compareTo(LocalDate.now()) > 0);
    }

}
