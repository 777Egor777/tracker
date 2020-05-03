package ru.job4j.tourcompany;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {

    @Test
    public void collectWhenEmptyList() {
        List<Profile> profiles = List.of();
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of();
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhenSingleProfile() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Saratov", "Bolshaya Kazachya", 100, 50))
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(
                new Address("Saratov", "Bolshaya Kazachya", 100, 50)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhenFewProfiles() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Saratov", "Bolshaya Kazachya", 100, 50)),
                new Profile(new Address("Saratov", "Bolshaya Gornaya", 100, 50)),
                new Profile(new Address("Saransk", "Moskowskaya", 36, 12))
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(
                new Address("Saransk", "Moskowskaya", 36, 12),
                new Address("Saratov", "Bolshaya Kazachya", 100, 50),
                new Address("Saratov", "Bolshaya Gornaya", 100, 50)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void collectWhenConsistEqualsProfiles() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Saratov", "Bolshaya Kazachya", 100, 50)),
                new Profile(new Address("Saratov", "Bolshaya Gornaya", 100, 50)),
                new Profile(new Address("Saransk", "Moskowskaya", 36, 12)),
                new Profile(new Address("Saransk", "Moskowskaya", 36, 12))
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = List.of(
                new Address("Saransk", "Moskowskaya", 36, 12),
                new Address("Saratov", "Bolshaya Kazachya", 100, 50),
                new Address("Saratov", "Bolshaya Gornaya", 100, 50)
        );
        assertThat(result, is(expected));
    }
}