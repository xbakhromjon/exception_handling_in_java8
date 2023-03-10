package uz.bakhromjon.handlingcheckedExceptions.way2;

import uz.bakhromjon.handlingcheckedExceptions.Problem;
import uz.bakhromjon.handlingcheckedExceptions.ThrowingConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class Solution {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(handlingConsumerWrapper(Problem::writeToFile, IOException.class));
    }

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {
        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
