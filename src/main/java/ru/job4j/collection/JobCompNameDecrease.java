package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class JobCompNameDecrease implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName()) * -1;
    }
}
