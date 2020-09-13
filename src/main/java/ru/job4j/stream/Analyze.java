package ru.job4j.stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream())
                .mapToInt(Subject::getScore)
                .average().getAsDouble();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(),
                x.getMarks().stream().mapToInt(Subject::getScore).average().getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream())
                .collect(Collectors.groupingBy(Subject::getName, HashMap::new,
                        Collectors.mapping(Subject::getScore, Collectors.toList())))
                .entrySet().stream().map(x -> new Tuple(x.getKey(),
                        x.getValue().stream().mapToInt(y -> y).average().getAsDouble()))
                .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(),
                x.getMarks().stream().mapToInt(Subject::getScore).sum()))
                .sorted(Comparator.comparingDouble(Tuple::getScore).reversed())
                .findFirst().get();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream())
                .collect(Collectors.groupingBy(Subject::getName, HashMap::new,
                        Collectors.mapping(Subject::getScore, Collectors.toList())))
                .entrySet().stream().map(x -> new Tuple(x.getKey(),
                        x.getValue().stream().mapToInt(y -> y).sum()))
                .sorted(Comparator.comparingDouble(Tuple::getScore).reversed())
                .findFirst().get();
    }
}
