package com.fabriciomoreira.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringValidatorTest {

    @ParameterizedTest
    @CsvSource({
            // emailText,            result
            "  moreira@gmail.com,           true",
            "  user-name@domain.com,        true",
            "  text@@gmail.com,             false",
            "  text@gmail?com,              false",
            "  a@gmail.com,                 true",
            "  textgmail.com,               false",
            "  text@gmail.com.com,          true",
            "  abc-d@mail.com,              true",
            "  abc.def@mail.com,            true",
            "  .abc@mail.com,               true",
            "  abc@mail.com,                true",
            "  abc#def@mail.com,            false",
            "  abc!def@mail.com,            false",
            "  abc?def@mail.com,            false",
            "  abc def@mail.com,            false",
            "  abc$def@mail.com,            false",
            "  abc*def@mail.com,            false",
            "  abc_def@mail.com,            true",
            "  abc1def@mail.com,            true",
            "  1abc_def@mail.com,           true",
            "  user.name@domain-mail.com,   true",
            "  user@mail#mail.com,          false",
            "                   ,           false",
            "  local_part_local_part_local_part_local_part_local_part_local_par@mail.com, true", // 65 char - allowed.
            "  local_part_local_part_local_part_local_part_local_part_local_pa@mail.com, true",    // 64 char - Allowed.
            "  Abc.example.com, false",                                                                 // (no @ character)
            "  A@b@c@example.com, false",                                                               //  (only one @ is allowed outside quotation marks)
            "  a\"b(c)d,e:f;g<h>i[j\\k]l@example.com, false",                                           //  (none of the special characters in this local-part are allowed outside quotation marks)
            "  just\"not\"right@example.com, false",                                                    //  (quoted strings must be dot separated or the only element making up the local-part)
            "  this is\"not\\allowed@example.com, false",                                               //  (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
            "  this\\ still\\\"not\\allowed@example.com, false",                                        //  (even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained by quotes)
            "  1234567890123456789012345678901234567890123456789012345678901234+x@example.com, false",  //  (local-part is longer than 64 characters)
            "  i_like_underscore@but_its_not_allowed_in_this_part.example.com, false",                  //  (Underscore is not allowed in domain part)
            "  QA[icon]CHOCOLATE[icon]@test.com, false"                                                 //  (icon characters)
    })
    @DisplayName("Should validate all e-mails from the list.")
    void email_test1(final String sText, final String sResult) {
        // Given
        var isValid = Boolean.parseBoolean(sResult);
        // When
        var result = StringValidator.isEmail(sText);
        // Then
        assertEquals(isValid, result);
    }
}
