package com.euler;

import java.math.BigInteger;

class Problem25 {
  private static final int TOTAL_DIGITS = 1000;
  private static final BigInteger test = BigInteger.valueOf(10).pow(TOTAL_DIGITS - 1);

  public static void main(String[] args) {
    BigInteger p0 = BigInteger.valueOf(0);
    BigInteger p1 = BigInteger.valueOf(1);

    int term = 1;
    while (true) {
      term++;
      BigInteger next = p0.add(p1);

      if (next.compareTo(test) >= 0) {
        System.out.println(term);
        return;
      }

      p0 = p1;
      p1 = next;
    }
  }
}
