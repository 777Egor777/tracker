package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparatorIncrease implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        int result = 1;
        int cmpId = o1.getId().compareTo(o2.getId());
        int cmpName = o1.getName().compareTo(o2.getName());
        if (cmpName < 0 || (cmpName == 0 && cmpId < 0)) {
            result = -1;
        } else if (cmpId == 0 && cmpName == 0) {
            result = 0;
        }
        return result;
    }
}
