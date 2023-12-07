package org.example;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        // Создаем коллекцию строк
        List<String> strings = Arrays.asList("поток", "функциональный интерфейс", "stream api", "абстрактный метод", "Predicate<T>", "лямбда-выражение");

        // Запросы с использованием Stream API

        // 1. Фильтрация строк, начинающихся с буквы "a"
        List<String> filteredStrings = strings.stream()
                .filter(s -> s.startsWith("а"))
                .toList();

        System.out.println("Фильтрация строк, начинающихся с буквы 'a': " + filteredStrings);

        // 2. Преобразование всех строк в верхний регистр
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println("Преобразование всех строк в верхний регистр: " + upperCaseStrings);

        // 3. Получение первой строки, длина которой больше 5 символов
        String firstLongString = strings.stream()
                .filter(s -> s.length() > 5)
                .findFirst()
                .orElse("Нет подходящей строки");

        System.out.println("Первая строка, длина которой больше 5 символов: " + firstLongString);

        // 4. Подсчет количества строк, содержащих букву "o"
        long countOfStringsContainingO = strings.stream()
                .filter(s -> s.contains("о"))
                .count();

        System.out.println("Количество строк, содержащих букву 'o': " + countOfStringsContainingO);

        // 5. Соединение всех строк в одну с разделителем
        String concatenatedString = String.join(", ", strings);

        System.out.println("Соединение всех строк в одну с разделителем: " + concatenatedString);
    }
}
