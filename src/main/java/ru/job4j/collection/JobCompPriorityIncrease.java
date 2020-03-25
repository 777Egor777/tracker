package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class JobCompPriorityIncrease implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}