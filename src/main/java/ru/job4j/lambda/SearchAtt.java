package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                result.add(att);
            }
        }
        return result;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                result.add(att);
            }
        }
        return result;
    }
}
