package org.example.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Info {

    private List<Long> listIntegers;
    private List<Double> listFloats;
    private List<String> listStrings;

    public Info(List<Long> listIntegers, List<Double> listFloats, List<String> listStrings) {
        this.listIntegers = listIntegers;
        this.listFloats = listFloats;
        this.listStrings = listStrings;
    }

    void selectingStatisticsType(boolean statistics) {
        if (statistics) {
            showsMaxumalInformation();
        } else showsMinimalInformation();
    }

    private void showsMinimalInformation() {
        System.out.print("+++ Краткая статистика +++ " +
                "\n##################################################\n");

        if (isEmptyList(listIntegers))
            System.out.print("Количество целых чисел: " + listIntegers.size() +
                "\n--------------------------------------------------\n");

        if (isEmptyList(listFloats))
            System.out.print("Количество вещественных чисел: " + listFloats.size() +
                "\n--------------------------------------------------\n");

        if (isEmptyList(listStrings))
            System.out.print("Количество строк: " + listStrings.size() +
                "\n##################################################\n");
    }

    private void showsMaxumalInformation() {

        System.out.print("+++ Полная статистика +++ " +
                "\n##################################################\n");

        if (isEmptyList(listIntegers)) {
            System.out.println("Количество целых чисел: "
                    + listIntegers.size());
            System.out.println("Минимальное значение целых чисел: " +
                    listIntegers.stream().mapToLong(Long::longValue).min().getAsLong());
            System.out.println("Максимально значение целых чисел: " +
                    listIntegers.stream().mapToLong(Long::longValue).max().getAsLong());
            System.out.println("Сумма всех целых чисел: " +
                    listIntegers.stream().mapToLong(Long::longValue).sum());
            System.out.print("Среднее значение целых чисел: " +
                    listIntegers.stream().mapToLong(Long::longValue).average().getAsDouble() +
                    "\n--------------------------------------------------\n");
        }

        if (isEmptyList(listFloats)) {
            System.out.println("Количество вещественных чисел: " + listFloats.size());
            System.out.println("Минимальное значение вещественных чисел: " +
                    listFloats.stream().mapToDouble(Double::doubleValue).min().getAsDouble());
            System.out.println("Максимально значение вещественных чисел: " +
                    listFloats.stream().mapToDouble(Double::doubleValue).max().getAsDouble());
            System.out.println("Сумма всех вещественных чисел: " +
                    listFloats.stream().mapToDouble(Double::doubleValue).sum());
            System.out.print("Среднее значение вещественных чисел: " +
                    listFloats.stream().mapToDouble(Double::doubleValue).average().getAsDouble() +
                    "\n--------------------------------------------------\n");
        }

        if (isEmptyList(listStrings)) {
            System.out.println("Количество строк: " + listStrings.size());
            System.out.println("Размер самой короткой строки: " +
                    Collections.min(listStrings, Comparator.comparing(s -> s.length())).length());
            System.out.print("Размер самой длинной строки: " +
                    Collections.max(listStrings, Comparator.comparing(s -> s.length())).length() +
                    "\n##################################################\n");
        }
    }
    private boolean isEmptyList(List list){
        if (list.isEmpty() || list == null) return false;
        return true;
    }
}
