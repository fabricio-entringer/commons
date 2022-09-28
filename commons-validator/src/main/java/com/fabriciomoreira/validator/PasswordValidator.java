package com.fabriciomoreira.validator;

public class PasswordValidator {

    public static PasswordRuleResult validate(final String password, final PasswordRule passwordRule) {
        if (password == null || passwordRule == null) {
            return null;
        }

    }
}
