package ru.job4j.lambda.flatmap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Integer> collect(Integer[][] nums) {
        return Stream.of(nums).flatMap(Stream::of).collect(Collectors.toList());
    }
}
