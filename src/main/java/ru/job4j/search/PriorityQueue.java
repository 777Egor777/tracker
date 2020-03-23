package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> queue = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        for (Task taskFromQueue : queue) {
            if (task.getPriority() < taskFromQueue.getPriority()) {
                break;
            }
            index++;
        }
        if (index == queue.size()) {
            queue.add(task);
        } else {
            queue.add(index, task);
        }
    }

    public Task take() {
        return queue.remove(0);
    }
}