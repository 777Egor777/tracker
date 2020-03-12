package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String rus = "Неизвестное слово. " + eng;
        return rus;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        dic.engToRus("Cat");
        dic.engToRus("Dog");
        dic.engToRus("Popinjay");
    }
}
