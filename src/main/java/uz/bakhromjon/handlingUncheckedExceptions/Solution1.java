package uz.bakhromjon.handlingUncheckedExceptions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class Solution1 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));
    }

    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }
}
