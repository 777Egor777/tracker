package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PaintTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Before testing method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void setBackOutput() {
        System.setOut(this.stdout);
        System.out.println("After testing method");
    }

    @Test
    public void drawSquare() {
        Shape shape = new Square();
        Paint paint = new Paint();
        paint.draw(shape);
        String result = new String(this.out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator()).add("****")
                                                                  .add("****")
                                                                  .add("****")
                                                                  .add("****").toString();
        assertThat(result, is(expected));
    }

    @Test
    public void drawTriangle() {
        Shape shape = new Triangle();
        Paint paint = new Paint();
        paint.draw(shape);
        String result = new String(this.out.toByteArray());
        String expected = new StringJoiner(System.lineSeparator()).add("   *   ")
                                                                  .add("  ***  ")
                                                                  .add(" ***** ")
                                                                  .add("*******").toString();
        assertThat(result, is(expected));
    }
}