package ru.itmo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> arrStrings = new ArrayList<>();
        arrStrings.add("hello");
        arrStrings.add("hi");
        arrStrings.add("his");
        System.out.println("Самая длинная строка из: " + arrStrings + " => " + longString(arrStrings));

        System.out.println("Hello палиндром????: " + isPalindrome("hello"));
        System.out.println("Mom палиндром????: " + isPalindrome("Mom"));

        System.out.println("Цензура: " + censorship("Ты бяка, уходи"));

        System.out.println("Кол-во подстрок hi в строке hello hi, myhidfs: " + countSubstring("Hello hi, myhidfs", "hi"));

        System.out.println("Инверсия текста hello Valera: " + reverseWords("hello Valera"));

        String content = new String(Files.readAllBytes(Paths.get("C://Users//pukki//Documents//PC/content.txt")), "UTF-8");
        System.out.println("Частотный словарь букв: " + buildDictionary(content));

    }

    public static String longString(ArrayList<String> arrayStrings) {
        String longString = arrayStrings.get(0);

        for (String str : arrayStrings) {
            if (str.length() > longString.length()) {
                longString = str;
            }
        }

        return longString;
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();

        return str.equals(new StringBuffer(str).reverse().toString());
    }

    public static String censorship(String text) {
        return text.replaceAll("бяка", "[вырезано цензурой]");
    }

    public static int countSubstring(String str, String substr) {
        int count = 0;
        int index = 0;

        while (str.indexOf(substr, index) != -1) {
            count++;
            index = str.indexOf(substr, index) + 1;
        }

        return count;
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuffer(words[i]).reverse().toString();
        }

        return String.join(" ", words);
    }

    public static Map<Character, Integer> buildDictionary(String text) {
        Map<Character, Integer> map = new HashMap<>();

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if ((ch >= 'а' && ch <= 'я') || ch == 'ё') {
                map.compute(ch, (character, integer)
                        -> integer == null ? 1 : integer + 1);
            }
        }

        return map;
    }

}
