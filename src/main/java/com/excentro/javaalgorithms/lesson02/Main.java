package com.excentro.javaalgorithms.lesson02;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 1. Создать массив большого размера (миллион элементов). 2. Заполнить массив случайными числами.
 * 3. Проверить скорость выполнения каждой сортировки. (Если время сортировки будет неприемлемо
 * долго, можете для массива из 100 000 элементов проверить)
 *
 * <p>BubbleSort time: 39409
 *
 * <p>SelectionSort time: 9832
 *
 * <p>InsertionSort time: 8608
 */
public class Main {
  /** Main class. */
  public static void main(final String[] args) {
    int capacity = 100_000;

    // Создаем массив
    final MyArrayList<Integer> arr = new MyArrayList<>();
    for (int i = 0; i < capacity; i++) {
      arr.add(ThreadLocalRandom.current().nextInt(100));
    }
    // копируем массивы
    final MyArrayList<Integer> arr2 = new MyArrayList<>(arr);
    final MyArrayList<Integer> arr3 = new MyArrayList<>(arr);

    bubbleSort(arr);
    selectionSort(arr2);
    insertionSort(arr3);

    MyArrayList<Integer> smallArr = new MyArrayList<>(10);
    smallArr.add(0, 100);
    for (int i = 0; i < 100; i++) {
      smallArr.add(i);
      System.out.printf(
          "Current smallArr capacity=%d, size=%d%n", smallArr.length(), smallArr.size());
      System.out.println(smallArr);
    }
  }

  private static void bubbleSort(MyArrayList<Integer> arr) {
    long startTime = System.currentTimeMillis();
    arr.bubbleSort(Comparator.naturalOrder());
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("BubbleSort time: " + elapsedTime);
  }

  private static void selectionSort(MyArrayList<Integer> arr2) {
    long startTime = System.currentTimeMillis();
    arr2.selectionSort();
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("SelectionSort time: " + elapsedTime);
  }

  private static void insertionSort(MyArrayList<Integer> arr3) {
    long startTime = System.currentTimeMillis();
    arr3.insertionSort();
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("InsertionSort time: " + elapsedTime);
  }
}
