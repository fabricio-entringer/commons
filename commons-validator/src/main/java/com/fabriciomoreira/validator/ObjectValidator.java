package com.fabriciomoreira.validator;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ObjectValidator {

    /**
     * Method returns true if all objects in the nested class are not null.
     * The user can pass how many objects need.
     * In case any object child is null, the method returns false.
     *
     * @return true if all objects are not null and false if anyone is null.
     */
    public static <T> boolean isNullSafe(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return result != null;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static <T> Optional<T> nullSafeGetter(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        }
        catch (NullPointerException | IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    public static <T, U> void nullSafeLogic(Supplier<T> supplier, Function<T,U> function) {
        try {
            function.apply(supplier.get());
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            return;
        }
    }
// https://stackoverflow.com/questions/10391406/java-avoid-checking-for-null-in-nested-classes-deep-null-checking
}
