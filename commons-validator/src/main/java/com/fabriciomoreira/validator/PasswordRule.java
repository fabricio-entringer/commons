package com.fabriciomoreira.validator;

import java.util.List;

public class PasswordRule {
    private final Integer minLength;
    private final Integer maxLength;
    private final Boolean allowWhiteSpace;
    private final Integer minNumber;
    private final Integer maxNumber;
    private final Integer minSpecialCharacter;
    private final Integer maxSpecialCharacter;
    private final Integer minUpperCase;
    private final Integer maxUpperCase;
    private final Integer minLowerCase;
    private final Integer maxLowerCase;
    private final List<String> dictionaryExclude;
    private final List<String> dictionarySubstringExclude;
    private final List<String> history;

    private PasswordRule(Builder builder) {
        this.minLength = builder.minLength;
        this.maxLength = builder.maxLength;
        this.allowWhiteSpace = builder.allowWhiteSpace;
        this.minNumber = builder.minNumber;
        this.maxNumber = builder.maxNumber;
        this.minSpecialCharacter = builder.minSpecialCharacter;
        this.maxSpecialCharacter = builder.maxSpecialCharacter;
        this.minUpperCase = builder.minUpperCase;
        this.maxUpperCase = builder.maxUpperCase;
        this.minLowerCase = builder.minLowerCase;
        this.maxLowerCase = builder.maxLowerCase;
        this.dictionaryExclude = builder.dictionaryExclude;
        this.dictionarySubstringExclude = builder.dictionarySubstringExclude;
        this.history = builder.history;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public Boolean getAllowWhiteSpace() {
        return allowWhiteSpace;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public Integer getMinSpecialCharacter() {
        return minSpecialCharacter;
    }

    public Integer getMaxSpecialCharacter() {
        return maxSpecialCharacter;
    }

    public Integer getMinUpperCase() {
        return minUpperCase;
    }

    public Integer getMaxUpperCase() {
        return maxUpperCase;
    }

    public Integer getMinLowerCase() {
        return minLowerCase;
    }

    public Integer getMaxLowerCase() {
        return maxLowerCase;
    }

    public List<String> getDictionaryExclude() {
        return dictionaryExclude;
    }

    public List<String> getDictionarySubstringExclude() {
        return dictionarySubstringExclude;
    }

    public List<String> getHistory() {
        return history;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer minLength;
        private Integer maxLength;
        private Boolean allowWhiteSpace;
        private Integer minNumber;
        private Integer maxNumber;
        private Integer minSpecialCharacter;
        private Integer maxSpecialCharacter;
        private Integer minUpperCase;
        private Integer maxUpperCase;
        private Integer minLowerCase;
        private Integer maxLowerCase;
        private List<String> dictionaryExclude;
        private List<String> dictionarySubstringExclude;
        private List<String> history;

        public Builder minLength(final Integer minLength) {
            this.minLength = minLength;
            return this;
        }

        public Builder maxLength(final Integer maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        private Builder allowWhiteSpace(final Boolean allowWhiteSpace) {
            this.allowWhiteSpace = allowWhiteSpace;
            return this;
        }

        private Builder minNumber(final Integer minNumber) {
            this.minNumber = minNumber;
            return this;
        }

        private Builder maxNumber(final Integer maxNumber) {
            this.maxNumber = maxNumber;
            return this;
        }

        private Builder minSpecialCharacter(final Integer minSpecialCharacter) {
            this.minSpecialCharacter = minSpecialCharacter;
            return this;
        }

        private Builder maxSpecialCharacter(final Integer maxSpecialCharacter) {
            this.maxSpecialCharacter = maxSpecialCharacter;
            return this;
        }

        private Builder minUpperCase(final Integer minUpperCase) {
            this.minUpperCase = minUpperCase;
            return this;
        }

        private Builder maxUpperCase(final Integer maxUpperCase) {
            this.maxUpperCase = maxUpperCase;
            return this;
        }

        private Builder minLowerCase(final Integer minLowerCase) {
            this.minLowerCase = minLowerCase;
            return this;
        }

        private Builder maxLowerCase(final Integer minLowerCase) {
            this.maxLowerCase = minLowerCase;
            return this;
        }

        private Builder dictionaryExclude(final List<String> dictionaryExclude) {
            this.dictionaryExclude = dictionaryExclude;
            return this;
        }

        private Builder dictionarySubstringExclude(final List<String> dictionarySubstringExclude) {
            this.dictionarySubstringExclude = dictionarySubstringExclude;
            return this;
        }

        private Builder history(List<String> history) {
            this.history = history;
            return this;
        }

        public PasswordRule build() {
            return new PasswordRule(this);
        }
    }

    enum InternalPasswordRule {
        MIN_LENGTH("The password doesn't have the minimum required length.", "aaa");

        private final String message;
        private final String regex;

        InternalPasswordRule(final String message, final String regex) {
            this.message = message;
            this.regex = regex;
        }

        public String getMessage() {
            return this.message;
        }

        public String getRegex() {
            return this.regex;
        }
    }

}

//IllegalCharacterRule – defines all characters that a password mustn't contain
//IllegalRegexRule – defines a regular expression which mustn't match
//IllegalSequenceRule – checks whether a password has an illegal sequence of characters
//NumberRangeRule – defines a range of numbers which a password mustn't contain
//WhitespaceRule – checks whether a password contains whitespaces
//DictionaryRule – checks whether a password is equal to any dictionary record
//DictionarySubstringRule – checks whether a password contain any dictionary record
//HistoryRule – checks whether a password contains any historical password reference
//DigestHistoryRule – checks whether a password contains any digested historical password reference
//SourceRule – checks whether a password contains any source password reference
//DigestSourceRule – checks whether a password contains any digest source password reference
//UsernameRule – checks whether a password contains a username
//RepeatCharacterRegexRule – checks whether a password contains repeated ASCII characters