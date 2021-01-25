package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* *
 * @author: Alejandro Córcoles
 */
public class Logger {
    public static void println(Color color, String text) { // Funció per canviar el color amb salt de línea.
        System.out.print(color);
        System.out.println(text);
        System.out.print(Color.RESET);
    }

    public static void print(Color color, String text) { // Funció per canviar el color sense salt de línea.
        System.out.print(color);
        System.out.print(text);
        System.out.print(Color.RESET);
    }

    public static void printf(Color color, String text, Object... params) {
        System.out.print(color);
        System.out.printf(text, params);
        System.out.print(Color.RESET);
    }

    /* Funció recursiva que primer comprova si el número introduït
     * és un número int. Si no ho és, llença un missatge d'error i es crida a si mateixa un altre cop.
     */
    public static int getInt(String prompt) {

        Scanner scanner = new Scanner(System.in);

        util.Logger.print(Color.BLUE_BOLD, prompt);

        String nextLine = scanner.nextLine();

        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException ignored) {
            util.Logger.println(Color.RED_BOLD, "Error. Has d'introduir un número.");

            return getInt(prompt);
        }
    }

    public static int getIntLimit(String prompt, int limit, int min) {
        int num = getInt(prompt);

        if (num <= limit && num >= min){
            return num;
        }

        return getIntLimit(prompt, limit, min);
    }

    public static String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Logger.print(Color.YELLOW_BOLD, prompt);

        return scanner.nextLine();
    }

    public static String getStringColor(Color color, String prompt) {
        Scanner scanner = new Scanner(System.in);
        util.Logger.print(color, prompt);

        return scanner.nextLine();
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    public static int getRandomIntList(ArrayList<Integer> list) {
        Random random = new Random();
        int num = getRandomInt(1, 90);
        if (list.size() > 0) {
            if (list.contains(num)) {
                return num;
            }
            return getRandomIntList(list);
        }
        return 0;
    }

    public static void printInt(Color color, int num) {
        System.out.print(color);
        System.out.print(num);
        System.out.print(Color.RESET);
        System.out.println(" s");
    }


    public static void printIntSpace(Color color, int num) {
        System.out.print(color);
        System.out.printf("%5d", num);
        System.out.print(Color.RESET);
    }

    public static char getChar(String prompt){
        Scanner scanner = new Scanner(System.in);

        util.Logger.print(Color.BLUE_BOLD, prompt);

        String nextLine = scanner.nextLine().toLowerCase();

        try {
            return nextLine.charAt(0);
        } catch (Exception ignored) {
            util.Logger.println(Color.RED_BOLD, "Error. Has d'introduir un càracter.");

            return getChar(prompt);
        }

    }
}
