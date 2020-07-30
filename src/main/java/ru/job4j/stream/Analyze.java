package ru.job4j.stream;

import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream()).mapToInt(Subject::getScore)
                .average().orElse(0.0);
    }

    public static double averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream()).mapToInt(Subject::getScore)
                .average().orElse(0.0);
    }

    public static double averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(Pupil::getMarks)
                .mapToDouble(marks -> marks.stream().mapToInt(Subject::getScore).average().orElse(0.0))
                .average().orElse(0.0);
    }

    public static Pupil bestStudent(Stream<Pupil> stream) {
        return stream.sorted((x, y) -> Double.compare(x.getMarks().stream().mapToInt(Subject::getScore).average().getAsDouble(),
                                       y.getMarks().stream().mapToInt(Subject::getScore).average().getAsDouble()) * -1)
                     .findFirst().get();
    }

    public static Subject bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getMarks().stream())
                     .sorted(Comparator.comparingInt(Subject::getScore).reversed())
                     .findFirst().get();
    }
}
