package org.example;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        // generate
        List<Integer> randomInts = new Random () // возвращает IntStream - спец. версия стрим для чисел (оптимизированная + особые методы)
                .ints(1000, 10, 10000)
                //.filter, map etc.
                // Примеры запросов с использованием Stream API
                .filter(n -> n % 2 == 0) // Фильтрация только четных чисел
                .limit(50) // Ограничение стрима 50 элементами
                .sorted() // Сортировка элементов стрима
                .mapToObj(Integer::valueOf) // Преобразование в Stream<Integer>
                .toList(); // Сбор данных в коллекцию

        System.out.println("Собранная коллекция: " + randomInts);

        long primeCount = new Random()
                .ints(1000, 10, 10000)
                .filter(n -> n > 1 && java.math.BigInteger.valueOf(n).isProbablePrime(50))
                .count(); // Подсчет количества простых чисел

        System.out.println("Количество простых чисел: " + primeCount);

        int sum = new Random()
                .ints(1000, 10, 10000)
                .reduce(0, Integer::sum); // Редукция множества значений к одному (сумма)

        System.out.println("Сумма чисел: " + sum);

        new Random()
                .ints(1000, 10, 10000)
                .limit(10)
                .forEach(System.out::println); // Просто вывод на консоль

        Map<Integer, String> numberToStringMap = new Random()
                .ints(1000, 10, 10000)
                .mapToObj(n -> Map.entry(n, " Number: " + n))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (existing, replacement) -> existing)); // Обработка дубликатов

        System.out.println("Карта чисел: " + numberToStringMap);
    }

}