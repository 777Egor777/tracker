package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void draw() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Shape shape = new Square();
        Paint paint = new Paint();
        paint.draw(shape);
        String result = new String(baos.toByteArray());
        String expected = new StringJoiner(System.lineSeparator()).add("****")
                                                                  .add("****")
                                                                  .add("****")
                                                                  .add("****").toString();
        assertThat(result, is(expected));
        System.setOut(stdout);
    }
}