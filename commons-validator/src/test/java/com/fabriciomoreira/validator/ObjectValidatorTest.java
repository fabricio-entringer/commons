package com.fabriciomoreira.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObjectValidatorTest {

    private Stream<Arguments> getFamilies() throws CloneNotSupportedException {
        Family family_1 = null;
        Family family_2 = new Family();
        Family family_3 = new Family() {{
            setPeoples(new ArrayList<>());
        }};
        Family family_4 = new Family() {{
            setPeoples(new ArrayList<>() {{
                add(new People());
            }});
        }};
        Family family_5 = new Family() {{
            setPeoples(new ArrayList<>() {{
                add(new People() {{
                    setAddress(new Address());
                }});
            }});
        }};
        Family family_6 = new Family() {{
            setPeoples(new ArrayList<>() {{
                add(new People() {{
                    setAddress(new Address() {{
                        setPostalCode("Postal Code");
                    }});
                }});
            }});
        }};

        return Stream.of(
                Arguments.of(family_1, false),
                Arguments.of(family_2, false),
                Arguments.of(family_3, false),
                Arguments.of(family_4, false),
                Arguments.of(family_5, false),
                Arguments.of(family_6, true)
        );
    }

    @ParameterizedTest
    @MethodSource("getFamilies")
    @DisplayName("Should validate null and not null in nested class.")
    void isNullSafe_test1(Family family, boolean expectedResult) {
        // Given

        // When, then
        var result = ObjectValidator.isNullSafe(() -> family.getPeoples().get(0).getAddress().getPostalCode());
        // Then
        assertEquals(expectedResult, result);
    }

    class Address {
        private String postalCode;

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
    }

    class People {
        private Address address;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    class Family implements Cloneable {
        private List<People> peoples;

        public List<People> getPeoples() {
            return peoples;
        }

        public void setPeoples(List<People> peoples) {
            this.peoples = peoples;
        }
    }

}
