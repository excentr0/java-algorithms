package com.excentro.javaalgorithms.lesson08;

public class Main {
  public static void main(String[] args) {
    // int x = Integer.MIN_VALUE;
    // System.out.println(x);
    //
    // System.out.println(Math.abs(x));
    //
    // System.out.println(Integer.toBinaryString(x));
    // System.out.println("0"+Integer.toBinaryString(0x7fffffff));


    ChainingHashMap<Integer, String> chm = new ChainingHashMap<>();
    chm.put(1, "one");
    chm.put(2, "two");
    chm.put(3, "three");
    chm.put(4, "four");
    chm.put(5, "five");
    System.out.println(chm);

    chm.delete(5);

    // System.out.println(chm.get(3));

    // Random random = new Random();

    // for (int i = 0; i < 6; i++) {
    // chm.put(random.nextInt(100), "");
    // }

    System.out.println(chm);
  }

}
