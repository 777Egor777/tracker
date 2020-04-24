package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaException {
    public static void throwExMethod() throws Exception {
        throw new Exception();
    }

    public interface Wrapper<T> {
        T get();
        void set(T t);
        boolean isEmpty();
    }

    public static class ExpHold<T> implements Wrapper<T> {
        private T value;

        @Override
        public T get() {
            return value;
        }

        @Override
        public void set(T t) {
            value = t;
        }

        @Override
        public boolean isEmpty() {
            return value == null;
        }
    }


    public static void main(String[] args) {
        final ExpHold<Exception> expHold = new ExpHold<>();
        List<String> names = Arrays.asList(
                "Alex",
                "Petr",
                "Egor"
        );
        names.forEach(
                n -> {
                    try {
                        throwExMethod();
                    } catch (Exception exc) {
                        expHold.set(exc);
                    }
                }
        );
    }
}
