package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println("Я великий оракул. Что ты хочешь узнать?");
        Scanner scanner = new Scanner(System.in);
        String userQuestion = scanner.nextLine();
        int randomNumber = new Random().nextInt(3);
        String answerToUser = "";
        switch (randomNumber) {
            case 0: answerToUser = "Да"; break;
            case 1: answerToUser = "Нет"; break;
            default: answerToUser = "Может быть"; break;
        }
        System.out.println(answerToUser);
    }
}
