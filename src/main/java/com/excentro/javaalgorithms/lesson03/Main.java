package com.excentro.javaalgorithms.lesson03;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    reverseString();

    testDeque();

    priorityQueueWithComparator();
  }

  private static void priorityQueueWithComparator() {
    MyPriorityQueue<Integer> queue = new MyPriorityQueue<>(10, Comparator.naturalOrder());
    queue.insertComp(1);
    queue.insertComp(2);
    queue.insertComp(3);
    queue.insertComp(4);
    queue.insertComp(5);
    System.out.println(queue);
  }

  private static void reverseString() {
    Scanner reader = new Scanner(System.in);
    System.out.println("Enter a string: ");
    invertString(reader.nextLine());
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

  private static void testDeque() {
    MyDeque<Integer> deque = new MyDeque<>();
    deque.insertLeft(3);
    deque.insertLeft(2);
    deque.insertLeft(1);
    deque.insertRight(4);
    deque.insertRight(5);
    deque.insertRight(6);
    deque.removeLeft();
    deque.removeRight();
    System.out.println(deque);
  }
}
