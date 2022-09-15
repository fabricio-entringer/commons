package com.fabriciomoreira.validator;

import java.util.regex.Pattern;

/**
 * StringValidator class aggregates all methods that aim to validate the string content or behavior.
 *
 * @since v 0.0.2-SNAPSHOT
 */
public class StringValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}$";
    private static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);

    private StringValidator() {
    }

    /**
     * Check if the e-mail address passed as parameter has all attributes to be considered a valid e-mail.
     * <p>
     * Ex.:
     * <ul>
     *     <li>An @ character.</li>
     *     <li>The domain with a suffix (com, io, etc.) separated by ".".</li>
     * </ul>
     * <p>
     * It's important to remember that the method doesn't check if the e-mail is registered in the domain or not!
     * Only the e-mail string format is checked with.
     * <p>
     *
     * @param mailAddress The e-mail address that must be verified.
     * @return True if the parameter is a valid e-mail, otherwise returns false.
     * @since v 0.0.2
     */
    public static boolean isEmail(String mailAddress) {
        if (mailAddress == null || mailAddress.isBlank())
            return false;

        return emailPattern
                .matcher(mailAddress)
                .matches();
    }



}
