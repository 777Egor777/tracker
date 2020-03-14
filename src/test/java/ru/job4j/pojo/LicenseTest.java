package ru.job4j.pojo;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LicenseTest {

    @Test
    public void equalsTest1() {
        License first = new License(null, null, null, null);
        License second = new License(null, null, null, null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest2() {
        License first = new License(null, null, null, null);
        License second = new License("null", null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest3() {
        License first = new License(null, null, null, null);
        License second = new License(null, "null", null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest4() {
        License first = new License(null, null, null, null);
        License second = new License(null, null, "null", null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest5() {
        License first = new License(null, null, null, null);
        License second = new License(null, null, null, new Date());
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest6() {
        License first = new License("", null, null, null);
        License second = new License(null, null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest7() {
        License first = new License(null, "", null, null);
        License second = new License(null, null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest8() {
        License first = new License(null, null, "", null);
        License second = new License(null, null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest9() {
        License first = new License(null, null, null, new Date());
        License second = new License(null, null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest10() {
        License first = new License(null, null, "", null);
        License second = new License(null, null, "", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTes11() {
        License first = new License("Petr", null, null, null);
        License second = new License("Petr", null, null, null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest12() {
        License first = new License(null, "firstModel", null, null);
        License second = new License(null, "firstModel", null, null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest13() {
        License first = new License(null, null, "code", null);
        License second = new License(null, null, "code", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest14() {
        Date date = new Date();
        License first = new License(null, null, null, date);
        License second = new License(null, null, null, date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest15() {
        Date date = new Date();
        Date date2 = date;
        License first = new License(null, null, null, date);
        License second = new License(null, null, null, date2);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest16() {
        License first = new License("Artem", null, null, null);
        License second = new License("Viktor", null, null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest17() {
        License first = new License("Artem", "Viktor", null, null);
        License second = new License("Artem", "NeViktor", null, null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest18() {
        License first = new License("Artem", "Viktor", "101", null);
        License second = new License("Artem", "Viktor", "277", null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest19() {
        License first = new License("Artem", "Viktor", "298", null);
        License second = new License("Artem", "Viktor", "277", null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest20() {
        License first = new License("Artem", "Viktor", "101", null);
        License second = new License("Artem", "Viktor", "101", new Date());
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest21() {
        License first = new License("Artem", "Viktor", "101", new Date());
        License second = new License("Artem", "Viktor", "101", null);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest22() {
        License first = new License("Artem", "Viktor", "101", new Date());
        License second = new License("Artem", "Viktor", "101", new Date());
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest23() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Artem", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest24() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Artem", "Viktor", "111", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest25() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Artem", "Viktor1", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest26() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artik", "Viktor", "101", date);
        License second = new License("Artem", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest27() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", null, "101", date);
        License second = new License("Artem", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest28() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", null, date);
        License second = new License("Artem", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest29() {
        Date date = new Date();
        Date date2 = date;
        License first = new License(null, "Viktor", "101", date);
        License second = new License("Artem", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest30() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Artem", "Viktor", null, date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest31() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Artem", null, "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest32() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License(null, "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest33() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "Viktor", "101", date);
        License second = new License("Pablo", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest34() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "first", "101", date);
        License second = new License("Artem", "second", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest35() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Artem", "first", "101", date);
        License second = new License("Artem", "aaa", "201", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest36() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Paul", "third", "99", date);
        License second = new License("Paul", "second", "99", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest37() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Evgen", "qq", "1231231", date);
        License second = new License("Evgen", "qq", "12312311", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest38() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Kirill", "Viktor", "101", date);
        License second = new License("Mefodii", "Viktor", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest39() {
        Date date = new Date();
        Date date2 = date;
        License first = new License("Vasilii", "oo1", "101", date);
        License second = new License("Vasilii", "oo2", "101", date2);
        boolean result = first.equals(second);
        boolean expected = false;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest40() {
        Date date = new Date();
        License first = new License("Anna", "i123112", "asdadasdas", date);
        License second = new License("Anna", "i123112", "asdadasdas", date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest41() {
        License first = new License("Egor", "aaa1232 wdfsae", "asdasdasfwfgwqef", null);
        License second = new License("Egor", "aaa1232 wdfsae", "asdasdasfwfgwqef", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest42() {
        Date date = new Date();
        License first = new License("Mark", "asf7sd98f7sd98fs7897989xc7v9x8cv789", "a8sd6as87d6a8zxczx8v6xcvb6cv87b6cv ", date);
        License second = new License("Mark", "asf7sd98f7sd98fs7897989xc7v9x8cv789", "a8sd6as87d6a8zxczx8v6xcvb6cv87b6cv ", date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest43() {
        License first = new License("Alex", "pxcivpxcvixop565", "nn;,lnm;lknml", null);
        License second = new License("Alex", "pxcivpxcvixop565", "nn;,lnm;lknml", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest44() {
        Date date = new Date();
        License first = new License("Erema", "asdasdbnmghfg", "ccvv43453", date);
        License second = new License("Erema", "asdasdbnmghfg", "ccvv43453", date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest45() {
        License first = new License("Larisa", "xxcvcvbcv", "zxccef", null);
        License second = new License("Larisa", "xxcvcvbcv", "zxccef", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest46() {
        License first = new License("Lex", "", "null", null);
        License second = new License("Lex", "", "null", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest47() {
        Date date = new Date();
        License first = new License(null, "ver1", "111", date);
        License second = new License(null, "ver1", "111", date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest48() {
        License first = new License("Grisha", null, "hkhhjkhjkhjkj", null);
        License second = new License("Grisha", null, "hkhhjkhjkhjkj", null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest49() {
        Date date = new Date();
        License first = new License(null, null, null, date);
        License second = new License(null, null, null, date);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }

    @Test
    public void equalsTest50() {
        License first = new License(null, "zxczxczczx", null, null);
        License second = new License(null, "zxczxczczx", null, null);
        boolean result = first.equals(second);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}