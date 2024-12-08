package com.doit.shift.strategies;


import com.doit.shift.FinalResult;

import java.util.Comparator;
import java.util.Optional;


public class CreateFullStatistic implements HandeFile {


    private int count_wrote_elements = 0;
    private Optional<Long> min_int;
    private Optional<Long> max_int;
    private long sum_int = 0;
    private float average_int = 0;
    private Optional<Float> min_float;
    private Optional<Float> max_float;
    private float sum_float = 0;
    private float average_float = 0;
    private int count_strings = 0;
    private Optional<String> min_string;
    private Optional<String> max_string;

    @Override
    public void execute(FinalResult finalResult) {
        count_wrote_elements = finalResult.getFound_floats().size()
                + finalResult.getFound_integers().size()
                + finalResult.getFound_strings().size();
        min_int = finalResult.getFound_integers().stream().min(Long::compareTo);
        max_int = finalResult.getFound_integers().stream().max(Long::compareTo);
        sum_int = finalResult.getFound_integers().stream().mapToLong(Long::longValue).sum();
        average_int = finalResult.getFound_integers().isEmpty() ? 0 : sum_int / (float) finalResult.getFound_integers().size();
        min_float = finalResult.getFound_floats().stream().min(Float::compareTo);
        max_float = finalResult.getFound_floats().stream().max(Float::compareTo);
        sum_float = (float) finalResult.getFound_floats().stream().mapToDouble(Float::floatValue).sum();
        average_float = finalResult.getFound_floats().isEmpty() ? 0 : sum_float / (float) finalResult.getFound_floats().size();
        count_strings = finalResult.getFound_strings().size();
        min_string = finalResult.getFound_strings().stream().min(Comparator.comparingInt(String::length));
        max_string = finalResult.getFound_strings().stream().max(Comparator.comparingInt(String::length));
        print_in_console();
    }

    private void print_in_console() {
        System.out.println("FullStatistic:");
        System.out.println("Количество записанных элементов: " + count_wrote_elements);
        System.out.println("Минимальное целое значение: " + (min_int.isPresent() ? min_int.get() : "Отсутвует"));
        System.out.println("Максимальное целое значение: " + (max_int.isPresent() ? max_int.get() : "Отсутвует"));
        System.out.println("Сумма целых чисел: " + sum_int);
        System.out.println("Среднее целое значение: " + average_int);
        System.out.println("Минимальное значение с плавающей точкой: " + (min_float.isPresent() ? min_float.get() : "Отсутсвует"));
        System.out.println("Максимальное значение с плавающей точкой: " + (max_float.isPresent() ? max_float.get() : "Отсутсвует"));
        System.out.println("Сумма значений с плавающей точкой: " + sum_float);
        System.out.println("Среднее значение с плавающей точкой: " + average_float);
        System.out.println("Минимальная строка: " + (min_string.orElse("Отсутвует")));
        System.out.println("Максимальная строка: " + (max_string.orElse("Отсутвует")));
        System.out.println("Количество строк: " + count_strings);
    }
}
