package com.euler;

import java.math.BigInteger;

public class Problem16 {
  static final BigInteger ten = new BigInteger("10");

  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    BigInteger digits = new BigInteger("2");
    digits = digits.pow(1000);

    BigInteger sum = new BigInteger("0");
    while (digits.doubleValue() > 0) {
      sum = sum.add(digits.subtract(digits.divide(ten).multiply(ten)));
      digits = digits.divide(ten);
    }

    System.out.println("Time to complete: " + (System.currentTimeMillis() - start) + " ms");
    System.out.println(sum);
  }
}
