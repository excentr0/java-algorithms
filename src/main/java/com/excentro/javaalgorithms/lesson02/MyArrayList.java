package com.excentro.javaalgorithms.lesson02;

import java.util.Comparator;

public class MyArrayList<T extends Comparable<T>> {
  private static final int DEFAULT_CAPACITY = 10;
  private final T[] list;
  private int size = 0;

  /**
   * Конструктор.
   */
  public MyArrayList(final int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("capacity : " + capacity);
    }
    list = (T[]) new Comparable[capacity];
  }

  public MyArrayList() {
    list = (T[]) new Comparable[DEFAULT_CAPACITY];
  }

  public void add(final T item) {
    list[size] = item;
    size++;
  }

  public void add(final int index, final T item) {
    checkCorrectIndex(index);

    if (size - index >= 0) {
      System.arraycopy(list, index, list, index + 1, size - index);
    }
    list[index] = item;
    size++;
  }

  private void checkCorrectIndex(final int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("no correct index" + index);
    }
  }

  public boolean remove(final T item) {
    int i = 0;
    while (i < size && !list[i].equals(item)) {
      i++;
    }
    if (i == size) {
      return false;
    }
    if (size - 1 - i >= 0) {
      System.arraycopy(list, i + 1, list, i, size - 1 - i);
    }
    size--;
    list[size] = null;
    return true;
  }

  public T get(final int index) {
    checkCorrectIndex(index);
    return list[index];
  }

  public void set(final int index, final T item) {
    checkCorrectIndex(index);
    list[index] = item;
  }

  public int size() {
    return size;
  }

  public boolean contains(final T item) {
    return indexOf(item) > -1;
  }

  public final int indexOf(final T item) {
    for (int i = 0; i < size; i++) {
      if (list[i].equals(item)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("[ ");
    for (int i = 0; i < size; i++) {
      sb.append(list[i]).append(", ");
    }
    sb.setLength(sb.length() - 2);
    sb.append(" ]");
    return sb.toString();
  }

  public void selectionSort() {
    for (int i = 0; i < size - 1; i++) {
      int iMin = i;
      for (int j = i + 1; j < size; j++) {
        if (less(list[j], list[iMin])) {
          iMin = j;
        }
      }
      swap(i, iMin);
    }
  }

  private boolean less(final T item1, final T item2) {
    return item1.compareTo(item2) < 0;
  }

  private void swap(final int index1, final int index2) {
    final T temp = list[index1];
    list[index1] = list[index2];
    list[index2] = temp;
  }

  public void insertionSort() {
    T key;
    for (int i = 1; i < size; i++) {
      int j = i;
      key = list[i];
      while (j > 0 && less(key, list[j - 1])) {
        list[j] = list[j - 1];
        j--;
      }
      list[j] = key;
    }
  }

  public void bubbleSort() {
    boolean isSwapped;
    for (int i = size - 1; i > 0; i--) {
      isSwapped = false;
      for (int j = 0; j < i; j++) {
        if (less(list[j + 1], list[j])) {
          swap(j + 1, j);
          isSwapped = true;
        }
      }
      if (!isSwapped) {
        return;
      }
    }
  }

  public void bubbleSort(final Comparator<T> comparator) {
    boolean isSwapped;
    for (int i = size - 1; i > 0; i--) {
      isSwapped = false;
      for (int j = 0; j < i; j++) {
        if (comparator.compare(list[j + 1], list[j]) < 0) {
          swap(j + 1, j);
          isSwapped = true;
        }
      }
      if (!isSwapped) {
        return;
      }
    }
  }
}
