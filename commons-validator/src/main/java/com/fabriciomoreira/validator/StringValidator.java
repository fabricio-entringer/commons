package com.fabriciomoreira.validator;

import java.util.regex.Pattern;

public class StringValidator {

    public static final String EMAIL_REGEX_PARTTERN = "^[a-z][a-zA-Z0-9'+./=^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    public static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX_PARTTERN);

    /**
     * @return True if the parameter is a valid e-mail, otherwise returns false.
     */
    public static boolean isEmail(String text) {
        if (text.isBlank())
            return false;

        return emailPattern
                .matcher(text)
                .matches();
    }

}
