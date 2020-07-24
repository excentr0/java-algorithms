package com.excentro.javaalgorithms.lesson02;

public class MySortedArrayList<T extends Comparable<T>> extends MyArrayList<T> {

  public int binaryFind(final T item) {
    int lo = 0;
    int hi = size() - 1;

    while (lo <= hi) {
      final int mid = lo + (hi - lo) / 2; // (lo + hi)/2
      if (item.compareTo(get(mid)) < 0) {
        hi = mid - 1;
      } else if (item.compareTo(get(mid)) > 0) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  @Override
  public void add(final T item) {
    int i = 0;
    while (i < size() && item.compareTo(get(i)) >= 0) {
      i++;
    }
    super.add(i, item);
  }

  @Override
  public void add(final int index, final T item) {
    add(item);
  }

  @Deprecated
  @Override
  public void set(final int index, final T item) {
    throw new UnsupportedOperationException("Данный метод в этм классе нельзя использовать");
  }
}
