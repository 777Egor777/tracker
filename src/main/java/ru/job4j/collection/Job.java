package ru.job4j.collection;

import java.util.Objects;

public class Job implements Comparable<Job> {
    private String name;
    private int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Job job = (Job)obj;
            result = Objects.equals(name, job.getName()) &&
                    priority == job.getPriority();
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Job{name='%s', priority='%d'}", name, priority);
    }

    @Override
    public int compareTo(Job o) {
        return Integer.compare(priority, o.getPriority());
    }
}
