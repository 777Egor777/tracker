package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList (int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int row = 0; row < array.length; ++row) {
            for (int column = 0; column < array[row].length; column++) {
                list.add(array[row][column]);
            }
        }
        return list;
    }
}
