package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
     private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> userOpt = findByPassport(passport);
        if (userOpt.isEmpty()) {
            // TODO if such user not exist
            throw new IllegalStateException("No such User");
        } else {
            List<Account> list = users.get(userOpt.get());
            if (list.contains(account)) {
                // TODO if such account already exist
                throw new IllegalStateException("Such Account already exist");
            } else {
                list.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return Optional.ofNullable(users.keySet().stream().filter(x -> x.getPassport().equals(passport)).
                findFirst().orElse(null));
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> result = Optional.empty();
        Optional<User> userOpt = findByPassport(passport);
        if (userOpt.isPresent()) {
            result = Optional.ofNullable(Stream.of(userOpt.get()).map(x -> users.get(x)).flatMap(Collection::stream).filter(x -> x.getRequisite().equals(requisite))
                    .findFirst().orElse(null));
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Optional<User> srcOpt = findByPassport(srcPassport);
        Optional<User> destOpt = findByPassport(destPassport);
        if (srcOpt.isEmpty() || destOpt.isEmpty()) {
            // TODO if no such users
            throw new IllegalStateException("No such User's");
        }
        Optional<Account> srcAccOpt = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccOpt = findByRequisite(destPassport, destRequisite);
        if (srcAccOpt.isEmpty() || destAccOpt.isEmpty()) {
            // TODO if no such accounts
            throw new IllegalStateException("No such Account's");
        }
        if (Double.compare(srcAccOpt.get().getBalance(), amount) >= 0) {
            srcAccOpt.get().setBalance(srcAccOpt.get().getBalance() - amount);
            destAccOpt.get().setBalance(destAccOpt.get().getBalance() + amount);
            result = true;
        }
        return result;
    }
}
