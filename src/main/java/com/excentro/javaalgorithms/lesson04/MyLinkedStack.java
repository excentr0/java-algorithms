package com.excentro.javaalgorithms.lesson04;

public class MyLinkedStack<T> {
  private final MyLinkedList<T> stack = new MyLinkedList<>();

  public void push(T item) {
    stack.insertFirst(item);
  }

  public T pop() {
    return stack.deleteFirst();
  }

  public T peek() {
    return stack.getFirst();
  }

  public int size() {
    return stack.size();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }
}
