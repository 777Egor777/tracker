package ru.job4j.tracker;

/**
 * Base class for all
 * classes that
 * implements "Input"
 * interface
 * @author Egor Geraskin (yegeraskin13@gmail.com)
 * @version $Id$
 */
public abstract class CommonInput implements Input {
    /**
     * Base method that
     * return newLine
     * from this type of
     * Input that we use
     * @return new line
     */
    public abstract String nextLine();
}
