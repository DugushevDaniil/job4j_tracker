package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простого банковского сервиса
 * @author Daniil
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит пользователей с привязанными к ним счетами
     * хранение осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод отвечает за добавление пользователя в систему,
     * предварительно осуществляя проверку наличия этого пользователя в системе,
     * в случае отсутствия - добавляет нового пользователя.
     * @param user пользователь которого добавляют в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод отвечает за удаление пользователя из системы
     * @param passport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя
     * @return возвращает true если пользователь успешно удален,
     * возвращает false, если пользователя с таким паспортом нет
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод отвечает за добавление нового счета пользователю,
     * предварительно проверяя, нет ли такого счета.
     * @param passport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя
     * @param account новый счет, по которому мы осуществляем проверку
     * и, в случае отсутствия совпадения, добавляем его пользователю
     */
    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        if (key != null) {
            List<Account> newAccount = users.get(key);
            if (!newAccount.contains(account)) {
                newAccount.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск нужного пользователя по паспорту
     * @param passport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя
     * @return возвращает искомого пользователя
     */
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

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя
     * @param requisite реквизиты искомого счета
     * @return возвращает искомый счет
     */
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

    /**
     * Метод предназначен для перевода денег между счетами пользователей
     * @param srcPassport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя,
     * со счета которого будут переведены деньги
     * @param srcRequisite реквизиты счета, с которого переводятся деньги
     * @param destPassport это уникальный идентификатор, с его помощью,
     * мы осуществляем поиск нужного нам пользователя,
     * на счет которого будут зачислены деньги
     * @param destRequisite реквизиты счета, на который зачисляются деньги
     * @param amount сумма перевода
     * @return Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод должен вернуть false.
     */
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

    /**
     * метод для теста, возвращает все счета пользователя
     * @param user пользователь счета которог мы хотим получить
     * @return возвращает все счета пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}