package com.excentro.javaalgorithms.lesson03;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
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
}
