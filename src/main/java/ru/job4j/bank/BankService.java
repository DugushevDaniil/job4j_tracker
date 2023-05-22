package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        if (key != null) {
            List<Account> newAccount = users.get(key);
            if (!newAccount.contains(account)) {
                newAccount.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User searchable = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                searchable = user;
                break;
            }
        }
        return searchable;
    }

    public Account findByRequisite(String passport, String requisite) {
        User key = findByPassport(passport);
        Account searchable = null;
        if (key != null) {
            for (Account account : users.get(key)) {
                String thisRequisite = account.getRequisite();
                if (thisRequisite.equals(requisite)) {
                    searchable = account;
                    break;
                }
            }
        }
        return searchable;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}