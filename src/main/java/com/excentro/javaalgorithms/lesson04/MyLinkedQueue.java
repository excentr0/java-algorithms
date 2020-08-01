package com.excentro.javaalgorithms.lesson04;

/** Реализовать LinkedQueue (очередь, на базе связанных списков.) */
public class MyLinkedQueue<T> {
  private final MyLinkedList<T> queue = new MyLinkedList<>();

  /**
   * Inserts the specified element into this queue if it is possible to do so immediately without
   * violating capacity restrictions, returning true upon success and throwing an
   * IllegalStateException if no space is currently available.
   *
   * @param item element
   * @return true if success
   */
  public boolean offer(T item) {
    queue.insertLast(item);
    return true;
  }

  /**
   * Retrieves, but does not remove, the head of this queue.
   *
   * @return element
   */
  public T element() {
    return queue.getFirst();
  }

  @Override
  public String toString() {
    return "MyLinkedQueue{" + "queue=" + queue + '}';
  }

  /**
   * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
   *
   * @return element
   */
  public T peek() {
    if (queue.isEmpty()) {
      return null;
    }
    return queue.getLast();
  }

  /**
   * Retrieves and removes the head of this queue, or returns null if this queue is empty.
   *
   * @return element
   */
  public T poll() {
    if (queue.isEmpty()) {
      return null;
    }
    return queue.deleteFirst();
  }

  /**
   * Retrieves and removes the head of this queue.
   *
   * @return element
   */
  public T remove() {
    return queue.deleteFirst();
  }
}
