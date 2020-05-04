package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private final LinkedList<Task> queue = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var taskFromQueue : queue) {
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
