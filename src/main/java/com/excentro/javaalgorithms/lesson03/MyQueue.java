package com.excentro.javaalgorithms.lesson03;

import java.util.EmptyStackException;

public class MyQueue<T> {
  private final int DEFAULT_CAPACITY = 10;
  private T[] list;
  private int size = 0;
  private int begin = 0;
  private int end = 0;

  // 0 1 2 3 4
  // 4     8 6
  //      b
  //  e

  public MyQueue(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity " + capacity);
    }
    list = (T[]) new Object[capacity];
  }

  public MyQueue() {
    list = (T[]) new Object[DEFAULT_CAPACITY];
  }

  public void insert(T item) {
    if (isFull()) {
      throw new StackOverflowError();
    }
    size++;
    list[end] = item;
    end = nextIndex(end);
  }

  public boolean isFull() {
    return size == list.length;
  }

  private int nextIndex(int index) {
    return (index + 1) % list.length;
  }

  public T remove() {
    T value = peek();
    size--;
    list[begin] = null;
    begin = nextIndex(begin);
    return value;
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return list[begin];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    if (!isEmpty()) {
      int i = begin;
      while (i != end) {
        sb.append(list[i]).append(", ");
        i = nextIndex(i);
      }
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }
}
