package com.excentro.javaalgorithms.lesson04;

import java.util.ListIterator;

public class Main {
  public static void main(String[] args) {
    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    myLinkedList.insertFirst(1);
    myLinkedList.insertFirst(2);
    myLinkedList.insertFirst(3);
    myLinkedList.insertLast(4);
    myLinkedList.insertLast(5);
    myLinkedList.insertLast(6);
    System.out.println(myLinkedList);

    ListIterator<Integer> integerListIterator = myLinkedList.listIterator();
    while (integerListIterator.hasNext()) {
      System.out.print(integerListIterator.next());
    }
    System.out.println();
    while (integerListIterator.hasPrevious()) {
      System.out.print(integerListIterator.previous());
    }
    System.out.println();

    MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    System.out.println(queue);
    System.out.println(queue.element());
    System.out.println(queue.peek());
    System.out.println(queue.remove());
    System.out.println(queue.poll());
    System.out.println(queue);
  }
}
