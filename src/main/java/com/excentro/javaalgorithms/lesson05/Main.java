package com.excentro.javaalgorithms.lesson05;

public class Main {
  public static void main(String[] args) {
    System.out.println(power(3, 5));
    System.out.println(fastPower(3, 5));
  }

  /** Возведение в степень. */
  public static long power(long x, long n) {
    if (n == 1) {
      return x;
    } else {
      return x * power(x, n - 1);
    }
  }

  /** Быстрое возведение в степень. */
  public static long fastPower(long x, long n) {
    if (n == 0) {
      return 1;
    }
    if (n % 2 == 1) {
      return x * fastPower(x, n - 1);
    } else {
      long p = fastPower(x, n / 2);
      return p * p;
    }
  }
}
