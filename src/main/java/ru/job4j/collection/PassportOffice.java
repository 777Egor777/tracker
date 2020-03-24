package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();
    public boolean add(Citizen citizen) {
        boolean result = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            result = true;
            citizens.put(citizen.getPassport(), citizen);
        }
        return result;
    }

    public Citizen get(String passport) {
        Citizen result = new Citizen("plug", "plug");
        if (citizens.containsKey(passport)) {
            result = citizens.get(passport);
        }
        return result;
    }
}
