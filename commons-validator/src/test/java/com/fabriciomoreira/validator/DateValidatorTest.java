package com.fabriciomoreira.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateValidatorTest {

    public static Stream<Arguments> getDates() {
        return Stream.of(
                Arguments.of(LocalDate.now(), false),
                Arguments.of(LocalDate.now().plusDays(1), true),
                Arguments.of(LocalDate.now().minusDays(1), false)
                );
    }

    @ParameterizedTest
    @MethodSource("getDates")
    @DisplayName("Should validate all e-mails from the list.")
    public void email_test1(final LocalDate date, final boolean pResult) {
        // Given

        // When
        var result = DateValidator.isGreaterThanNow(date);
        // Then
        assertEquals(pResult, result);
    }
}
