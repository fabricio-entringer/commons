package com.fabriciomoreira.validator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringValidatorTest {

    @ParameterizedTest
    @CsvSource({
            // emailText,            result
            "  moreira@gmail.com,    true",
            "  user-name@domain.com, true",
            "  text@@gmail.com,      false",
            "  text@gmail?com,       false",
            "  a@gmail.com,          false",
            "  textgmail.com,        false",
            "  text@gmail.com.com,   true",
            "  abc-d@mail.com,       true",
            "  abc.def@mail.com,     true",
            "  .abc@mail.com,        false",
            "  abc@mail.com,         true",
            "  abc#def@mail.com,     false",
            "  abc!def@mail.com,     false",
            "  abc?def@mail.com,     false",
            "  abc def@mail.com,     false",
            "  abc$def@mail.com,     false",
            "  abc*def@mail.com,     false",
            "  abc_def@mail.com,     true",
            "  abc1def@mail.com,     true",
            "  1abc_def@mail.com,    false",
            "                   ,    false"

    })
    @DisplayName("Should validate all e-mails from the list.")
    public void email_test1(final String sText, final String sResult){
        // Given
        var isValid = Boolean.parseBoolean(sResult);
        // When
        var result = StringValidator.isEmail(sText);
        // Then
        assertEquals(isValid, result);
    }
}
