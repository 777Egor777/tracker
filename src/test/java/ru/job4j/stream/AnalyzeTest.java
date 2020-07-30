package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void averageScoreWhenSinglePupilWithSingleSubject() {
        assertEquals(Analyze.averageScore(
                Stream.of(
                        new Pupil("Egor", List.of(
                                new Subject("Math", 83)
                        ))
                )
        ), 83D, 0.00001);
    }

    @Test
    public void averageScoreWhenSinglePupilWithFewSubjects() {
        assertEquals(Analyze.averageScore(
                Stream.of(
                        new Pupil("Egor", List.of(
                                new Subject("Math", 87),
                                new Subject("Russian", 82),
                                new Subject("Informatics", 100)
                        ))
                )
        ), 269.0 / 3, 0.00001);
    }

    @Test
    public void averageScoreWhenTwoPupil() {
        assertEquals(Analyze.averageScore(
                Stream.of(
                        new Pupil("Egor", List.of(
                                new Subject("Math", 87),
                                new Subject("Russian", 82),
                                new Subject("Informatics", 100)
                        )),
                        new Pupil("Alex", List.of(
                                new Subject("Math", 100)
                        ))
                )
        ), 369.0 / 4, 1e-9);
    }

    @Test
    public void averageScoreByPupil() {
        assertEquals(Analyze.averageScoreByPupil(Stream.of(
                new Pupil("Mark", List.of(
                        new Subject("Math", 50),
                        new Subject("English", 100)
                )),
                new Pupil("Alex", List.of(
                        new Subject("Math", 100),
                        new Subject("Russian", 80)
                ))
        )), 82.5, 1e-9);
    }

    @Test
    public void bestStudent() {
        Pupil alex = new Pupil("Alex", List.of(
                new Subject("Math", 50),
                new Subject("Russian", 40),
                new Subject("Physics", 30)
        ));
        Pupil bob = new Pupil("Bob", List.of(
                new Subject("Math", 100),
                new Subject("Russian", 100),
                new Subject("Physics", 100)
        ));
        Pupil tom = new Pupil("Tom", List.of(
                new Subject("Math", 70),
                new Subject("Russian", 80),
                new Subject("Physics", 50)
        ));
        Pupil result = Analyze.bestStudent(Stream.of(alex, bob, tom));
        assertThat(result, is(bob));
    }

    @Test
    public void bestSubject() {
        Pupil alex = new Pupil("Alex", List.of(
                new Subject("Math", 50),
                new Subject("Russian", 90),
                new Subject("Physics", 30)
        ));
        Pupil bob = new Pupil("Bob", List.of(
                new Subject("Math", 55),
                new Subject("Russian", 12),
                new Subject("Physics", 60)
        ));
        Subject tomPhysics = new Subject("Physics", 92);
        Pupil tom = new Pupil("Tom", List.of(
                new Subject("Math", 70),
                new Subject("Russian", 33),
                tomPhysics
        ));
        Subject result = Analyze.bestSubject(Stream.of(alex, bob, tom));
        assertThat(result, is(tomPhysics));
    }
}