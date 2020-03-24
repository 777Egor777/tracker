package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("xxx111222", "Egor");
        BankService service = new BankService();
        service.addUser(user);
        User result = service.findByPassport(user.getPassport());
        User expected = new User("xxx111222", "Egor");
        assertThat(result, is(expected));
    }

    @Test
    public void addAccount() {
        User user = new User("xxx111222", "Egor");
        BankService service = new BankService();
        service.addUser(user);
        Account account = new Account("123123132", 100.2);
        service.addAccount(user.getPassport(), account);
        Account result = service.findByRequisite(user.getPassport(), account.getRequisite());
        Account expected = new Account("123123132", 100.2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoundByPassport() {
        User user = new User("###asdd1122", "Viktor");
        BankService service = new BankService();
        service.addUser(user);
        User result = service.findByPassport(user.getPassport());
        User expected = new User("###asdd1122", "Egor");
        assertThat(result, is(expected));
    }

    @Test
    public void whenNotFoundByPassport() {
        User user = new User("###asdd1122", "Viktor");
        BankService service = new BankService();
        service.addUser(user);
        User result = service.findByPassport("##asdd1122");
        User expected = new User("plug", "plug");
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoundByRequisite() {
        User user = new User("xxx111222", "Egor");
        BankService service = new BankService();
        service.addUser(user);
        Account account = new Account("12123123121123132", 102.2);
        service.addAccount(user.getPassport(), account);
        Account result = service.findByRequisite(user.getPassport(), account.getRequisite());
        Account expected = new Account("12123123121123132", 102.2);
        assertThat(result, is(expected));
    }

    @Test
    public void whenNotFoundByRequisite() {
        User user = new User("xxx111222", "Egor");
        BankService service = new BankService();
        service.addUser(user);
        Account account = new Account("12123123121123132", 102.2);
        service.addAccount(user.getPassport(), account);
        Account result = service.findByRequisite(user.getPassport(), "ghjfg fghaer123");
        Account expected = new Account("plug", 0D);
        assertThat(result, is(expected));
    }

    @Test
    public void transferMoney() {
        User user = new User("xxx111222", "Egor");
        BankService service = new BankService();
        service.addUser(user);
        Account firstAcc = new Account("12123123121123132", 102.2);
        service.addAccount(user.getPassport(), firstAcc);
        Account secondAcc = new Account("12sdsdff23121123132", 200D);
        service.addAccount(user.getPassport(), secondAcc);
        service.transferMoney(user.getPassport(), firstAcc.getRequisite(),
                              user.getPassport(), secondAcc.getRequisite(),
                              100D);
        double result = service.findByRequisite(user.getPassport(), secondAcc.getRequisite()).getBalance();
        double expected = 300D;
        assertThat(result, is(expected));
    }
}