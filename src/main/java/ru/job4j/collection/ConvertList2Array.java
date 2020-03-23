package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        //Easier than in
        //task conditions
        int groups = (list.size() + cells - 1) / cells;
        int[][] array = new int[groups][cells];
        int index = 0;
        for (int row = 0; row < groups; ++row) {
            for (int column = 0; column < cells; ++column) {
                array[row][column] = index < list.size() ? list.get(index++) : 0;
            }
        }
        return array;
    }
}
