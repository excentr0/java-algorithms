package com.excentro.javaalgorithms.lesson02;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 1. Создать массив большого размера (миллион элементов). 2. Заполнить массив случайными числами.
 * 3. Проверить скорость выполнения каждой сортировки. (Если время сортировки будет не приемлимо
 * долго, можете для массива из 100 000 элементов проверить)
 *
 * Пузырьковая сортировка 35910 мс
 *
 * Сортировка выбором 5890 мс
 *
 * Сортировка вставками 12827 мс
 */
public class Main {
  /** Main class. */
  public static void main(final String[] args) {
    // Создаем массив
    final MyArrayList<Integer> arr = new MyArrayList<>();
    for (int i = 0; i < 100_000; i++) {
      arr.add(ThreadLocalRandom.current().nextInt(100));
    }
    final MyArrayList<Integer> arr2 = MyArrayList(arr);
    final MyArrayList<Integer> arr3 = MyArrayList(arr);

    long startTime = System.currentTimeMillis();
    arr.bubbleSort();
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("BubbleSort time: " + elapsedTime);

    startTime = System.currentTimeMillis();
    arr2.selectionSort();
    stopTime = System.currentTimeMillis();
    elapsedTime = stopTime - startTime;
    System.out.println("SelectionSort time: " + elapsedTime);

    startTime = System.currentTimeMillis();
    arr3.insertionSort();
    stopTime = System.currentTimeMillis();
    elapsedTime = stopTime - startTime;
    System.out.println("InsertionSort time: " + elapsedTime);
  }

}
