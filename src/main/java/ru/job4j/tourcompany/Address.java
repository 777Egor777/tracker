package ru.job4j.tourcompany;

import java.util.Objects;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null && obj.getClass() == getClass()) {
            Address address = (Address) obj;
            result = city.equals(address.city)
                    && street.equals(address.street)
                    && home == address.home
                    && apartment == address.apartment;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    public String getCity() {
        return city;
    }
}
