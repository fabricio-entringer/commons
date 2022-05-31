package com.fabriciomoreira.validator;

import java.time.LocalDate;

public class DateValidator {

    /**
     * Check if the date passed by parameter is greater than now.
     * @return true if the parameter is greater than Now().
     */
    public static boolean isGreaterThanNow(LocalDate date) {
        if (date == null) {
            return false;
        }
        return (date.compareTo(LocalDate.now()) > 0);
    }

}
