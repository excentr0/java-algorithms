package com.excentro.javaalgorithms.lesson06;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
  /**
   * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить двадцать
   * деревьев с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев,
   * представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться
   * случайным образом в диапазоне от -100 до 100.
   *
   * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
   *
   * Процент несбалансированных деревьев: 85.0 - 90.0
   */
  public static void main(String[] args) {
    int balanced = 0;
    int count = 20;
    for (int i = 0; i < count; i++) {
      MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
      int level = ThreadLocalRandom.current().nextInt(64);
      for (int j = 0; j < level; j++) {
        int randomNum = ThreadLocalRandom.current().nextInt(-100, 100);
        treeMap.put(randomNum, randomNum);
      }
      if (!treeMap.isBalanced()) {
        balanced++;
      }
    }
    System.out.println("Процент несбалансированных деревьев: " + (float) balanced / count * 100);
  }
}
