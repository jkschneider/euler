package com.euler;

import java.math.BigInteger;

public class Problem48 {
  public static void main(String[] args) {
    BigInteger b = BigInteger.valueOf(1);
    for (int i = 2; i <= 1000; i++)
      b = b.add(BigInteger.valueOf(i).pow(i));

    String bStr = b.toString();
    System.out.println(bStr.substring(bStr.length() - 10));
  }
}
