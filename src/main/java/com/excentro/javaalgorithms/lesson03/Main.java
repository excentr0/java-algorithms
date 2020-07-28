package com.excentro.javaalgorithms.lesson03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    reverseString();

    testDeque();
  }

  private static void reverseString() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter a string: ");
    invertString(reader.nextLine());
  }

  private static void testDeque() {
    MyDeque<Integer> deque = new MyDeque<>();
    deque.insertLeft(1);
    deque.insertLeft(2);
    deque.insertLeft(3);
    deque.insertRight(4);
    deque.insertRight(5);
    deque.insertRight(6);
    deque.removeLeft();
    deque.removeRight();
    System.out.println(deque);
  }

  /** 1. Создать программу, которая переворачивает вводимые строки (читает справа налево). */
  private static void invertString(String reader) {
    MyStack<Character> stack = new MyStack<>(reader.length());
    for (int i = 0; i < reader.length(); i++) {
      stack.push(reader.charAt(i));
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }
}
