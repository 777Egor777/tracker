package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Egor Geraskin(yegeraskin13@gmail.com)
 * @version 1.0
 * @since 09.02.2021
 */
public class Context {
    private Map<String, Object> els = new HashMap<>();

    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors: " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<>();
        for (Class arg: con.getParameterTypes()) {
             if (!els.containsKey(arg.getCanonicalName())) {
                 throw new IllegalStateException("Object doesn't found in context: " + arg.getCanonicalName());
             }
             args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception ex) {
            throw new IllegalStateException("Couldn'r create instance of: " + cl.getCanonicalName(), ex);
        }
    }

    public <T> T get(Class<T> cl) {
        return (T) els.get(cl.getCanonicalName());
    }
}
