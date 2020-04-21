package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAttAdvanced {
    public static List<Attachment> loop(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> result = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                result.add(att);
            }
        }
        return result;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return loop(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return loop(list, predicate);
    }
}
