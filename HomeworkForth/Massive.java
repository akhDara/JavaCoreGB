package HomeworkForth;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Massive {
    public static void main(String[] args) {

        doPhoneBooks();
        System.out.println("_____________________________________");

        // 1. Задание
        List<String> setElements = asList("Первый", "Первый", "Второй", "Третий", "Третий", "Третий", "Четвертый", "Четвертый", "Пятый", "Шестой", "Шестой", "Шестой", "Седьмой", "Восьмой", "Восьмой", "Девятый");
        System.out.println("Полный массив: "+ setElements);

        Set<String> uniqueElements = new HashSet<>(setElements);
        System.out.println("Массив из уникальных значений: " + uniqueElements);

        System.out.println(" ___________________________________  ");
        Map<String, Integer> frequency = setElements.stream().collect(Collectors.toMap(  e -> e, e -> 1, Integer::sum));
        System.out.println("Повторяемость элементов в массиве: " + frequency);

    }
    //2. Задание
    public static void doPhoneBooks(){
        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.addElementPhoneBook("Саша","89338769876");
        phoneNumbers.addElementPhoneBook("Саша","89670049111");
        phoneNumbers.addElementPhoneBook("Катя","89670049111");
        phoneNumbers.addElementPhoneBook("Света","1234567890");
        phoneNumbers.addElementPhoneBook("Игорь","0987654321");
        phoneNumbers.addElementPhoneBook("Сергей","1324568709");
        phoneNumbers.addElementPhoneBook("Анатолий","89319669787");
        phoneNumbers.addElementPhoneBook("Анатолий","809866513465");

        System.out.println("Саша: " + phoneNumbers.getPhonesByName("Саша"));
        System.out.println("Катя: " + phoneNumbers.getPhonesByName("Катя"));
        System.out.println("Анатолий: " + phoneNumbers.getPhonesByName("Анатолий"));
        System.out.println("Юля: " + phoneNumbers.getPhonesByName("Юля"));
    }
}
