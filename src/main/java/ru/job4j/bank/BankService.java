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
        boolean rsl = false;
        if (findByPassport(passport) != null) {
            users.remove(findByPassport(passport));
            if (users.get(findByPassport(passport)) == null) {
                rsl = true;
            }
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        List<Account> newAccount = users.get(findByPassport(passport));
        if (!newAccount.contains(account)) {
            newAccount.add(account);
        }
        users.put(findByPassport(passport), newAccount);
    }

    public User findByPassport(String passport) {
        User searchable = null;
        for (User user : users.keySet()) {
           if(user.getPassport().equals(passport)) {
               searchable = user;
           }
        }
        return searchable;
    }

    public Account findByRequisite(String passport, String requisite) {
        User key = findByPassport(passport);
        Account searchable = null;
        if (!(key == null)) {
            for (Account account : users.get(key)) {
                String thisRequisite = account.getRequisite();
                if (thisRequisite.equals(requisite)) {
                    searchable = account;
                }
            }
        }
        return searchable;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        User key1 = findByPassport(srcPassport);
        User key2 = findByPassport(destPassport);
        boolean rsl = false;
            Account srcAccount = findByRequisite(key1.getPassport(), srcRequisite);
            Account destAccount = findByRequisite(key2.getPassport(), destRequisite);
            if (srcAccount != null && destAccount != null) {
                if (srcAccount.getBalance() >= amount) {
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    srcAccount.setBalance(srcAccount.getBalance() - amount);
                    rsl = true;
                }
            }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}