package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    public final static User EMPTY_USER = new User("#####EMPTY#####12321", "#####EMPTY#####12321");
    public final static Account EMPTY_ACCOUNT = new Account("#####EMPTY#####12321", 0D);

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user.equals(EMPTY_USER)) {
            // TODO if such user not exist
            throw new IllegalStateException("No such User");
        } else {
            List<Account> list = users.get(user);
            if (list.contains(account)) {
                // TODO if such account already exist
                throw new IllegalStateException("Such Account already exist");
            } else {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream().filter(x -> x.getPassport().equals(passport)).
                findFirst().orElse(EMPTY_USER);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = EMPTY_ACCOUNT;
        User user = findByPassport(passport);
        if (!user.equals(EMPTY_USER)) {
            result = Stream.of(user).map(x -> users.get(x)).flatMap(Collection::stream).filter(x -> x.getRequisite().equals(requisite))
                    .findFirst().orElse(EMPTY_ACCOUNT);
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        User src = findByPassport(srcPassport);
        User dest = findByPassport(destPassport);
        if (src.equals(EMPTY_USER) || dest.equals(EMPTY_USER)) {
            // TODO if no such users
            throw new IllegalStateException("No such User's");
        }
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.equals(EMPTY_ACCOUNT) || destAcc.equals(EMPTY_ACCOUNT)) {
            // TODO if no such accounts
            throw new IllegalStateException("No such Account's");
        }
        if (Double.compare(srcAcc.getBalance(), amount) >= 0) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            result = true;
        }
        return result;
    }
}
