package uz.bakhromjon.handlingcheckedExceptions;

/**
 * @author : Bakhromjon Khasanboyev
 **/
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}

