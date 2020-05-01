package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        User result = EMPTY_USER;
        List<User> goodUsers = users.keySet().stream().filter(x -> x.getPassport().equals(passport)).collect(Collectors.toList());
        if (!goodUsers.isEmpty()) {
            result = goodUsers.get(0);
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = EMPTY_ACCOUNT;
        User user = findByPassport(passport);
        if (!user.equals(EMPTY_USER)) {
            List<Account> accounts = users.get(user);
            int index = accounts.indexOf(new Account(requisite, 0D));
            if (index >= 0) {
                result = accounts.get(index);
            }
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
        } else {
            List<Account> srcAccList = users.get(src);
            List<Account> destAccList = users.get(dest);
            int srcAccIndex = srcAccList.indexOf(new Account(srcRequisite, 0D));
            int destAccIndex = destAccList.indexOf(new Account(destRequisite, 0D));
            if (srcAccIndex == -1 || destAccIndex == -1) {
                // TODO if no such accounts
                throw new IllegalStateException("No such Account's");
            } else {
                Account srcAcc = srcAccList.get(srcAccIndex);
                Account destAcc = destAccList.get(destAccIndex);
                if (Double.compare(srcAcc.getBalance(), amount) < 0) {
                    // TODO if not so much money on balance
                    throw new IllegalStateException("Not enough money on balance");
                } else {
                    srcAcc.setBalance(srcAcc.getBalance() - amount);
                    destAcc.setBalance(destAcc.getBalance() + amount);
                }
            }
        }
        return result;
    }
}
