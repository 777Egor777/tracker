package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matches {
    /**
     * Static method, that organize
     * interactive input of the
     * integer number from
     * diapason [start, finish]
     * @param message Start message,
     *                output to console
     *                before user
     *                can print number
     * @param start - beginning of the
     *                diapason
     * @param finish - end of the
     *                 diapason
     * @return number that user enter
     */
    public static int getInputNumberFromDiapason(String message, int start, int finish) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        while (!(result >= start && result <= finish)) {
            System.out.print(message);
            result = Integer.parseInt(reader.readLine());
        }
        System.out.println();
        return result;
    }

    /**
     * Method realise interactive
     * process of one move
     * of some user in this
     * game.
     * @param message - special information
     *                  about this move.
     *                  May contain information
     *                  about user.
     *                  Method also inform user
     *                  about remaining count
     *                  of mathes in the
     *                  common heap.
     * @param countOfMatches - count of mathes,
     *                         that remains in
     *                         the common heap
     * @return count of matches
     *         that remains in
     *         the heap.
     */
    public static int move(String message, int countOfMatches) throws IOException {
        System.out.println(String.format("В куче %s спичек.", countOfMatches));
        countOfMatches -= Matches.getInputNumberFromDiapason(message, 1, Math.min(3, countOfMatches));
        return countOfMatches;
    }

    /**
     * Main class(and only class)
     * of the interactive game "Mathes",
     * in witch two users can
     * get from 1 to 3 mathes
     * from the common heap.
     * At start there are 11
     * mathes in the heap.
     * Wins user, that moves last.
     * @author Geraskin Egor (yegeraskin13@gmail.com)
     * @version 1.0
     * @param args params of the compiler
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Игра 11.");
        System.out.println("За один ход можно взять от 1 до 3 спичек.\n");
        int countOfMatches = 11;
        while (countOfMatches > 0) {
            countOfMatches = Matches.move("Игрок1: ", countOfMatches);
            if (countOfMatches == 0) {
                System.out.println("Выиграл игрок 1.");
                break;
            }
            countOfMatches = Matches.move("Игрок2: ", countOfMatches);
            if (countOfMatches == 0) {
                System.out.println("Выиграл игрок 2.");
                break;
            }
        }
        System.out.println("Игра завершена!");
    }
}
