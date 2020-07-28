package com.excentro.javaalgorithms.lesson03;

public class MyDeque<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private final T[] list;
  private int size = 0;
  private int begin = 0;
  private int end = 0;

  public MyDeque(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Deque size can not be null");
    }
    list = (T[]) new Object[capacity];
  }

  public MyDeque() {
    list = (T[]) new Object[DEFAULT_CAPACITY];
  }

  public void insertLeft(T item) {
    if (isFull()) {
      throw new StackOverflowError();
    }
    size++;
    begin = prevIndex(begin);
    list[begin] = item;
  }

  public boolean isFull() {
    return size == list.length;
  }

  private int prevIndex(int index) {
    if (index > 0) {
      return index - 1;
    } else {
      return list.length - 1;
    }
  }

  public void insertRight(T item) {
    if (isFull()) {
      throw new StackOverflowError();
    }
    size++;
    list[end] = item;
    end = nextIndex(end);
  }

  private int nextIndex(int index) {
    return (index + 1) % list.length;
  }

  public T removeLeft() {
    T tmp = list[end];
    size--;
    list[begin] = null;
    begin = nextIndex(begin);
    return tmp;
  }

  public T removeRight() {
    T tmp = list[end];
    size--;
    list[end] = null;
    end = prevIndex(end);
    return tmp;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    int i = begin;
    if (!isEmpty()) {
      while (i != end) {
        sb.append(list[i]).append(", ");
        i = nextIndex(i);
      }
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
