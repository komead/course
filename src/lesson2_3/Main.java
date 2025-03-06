package lesson2_3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        String[] words = new String[] {
                "AA", "BB", "CC", "DD", "AD",
                "AA", "BA", "DD", "DD", "AB",
                "BB", "CB", "BB", "AA", "BD",
                "CC", "DA", "AA", "BC", "AA"

        };

        printMap(countRepeats(words));

        // Задание 2
        TelephoneBook phoneBook = new TelephoneBook();

        phoneBook.add("1234567", "Хорошун");
        phoneBook.add("8391046", "Марчук");
        phoneBook.add("2943729", "Бесан");
        phoneBook.add("4242424", "Марчук");

        phoneBook.get("Марчук");
    }

    private static HashMap<String, Integer> countRepeats(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }

    private static void printMap(HashMap<String, Integer> map) {
        for (String word : map.keySet()) {
            System.out.println("Слово \"" + word + "\" использовалось столько раз: " + map.get(word));
        }
    }
}
