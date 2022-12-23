package uz.bakhromjon.handlingcheckedExceptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : Bakhromjon Khasanboyev
 **/
public class Problem {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(i -> {
            try {
                writeToFile(i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static void writeToFile(Integer integer) throws IOException {
        // logic to write to file which throws IOException
    }


}
