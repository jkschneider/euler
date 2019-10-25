package com.euler;

public class Problem33 {
  public static void main(String[] args) {
    for (int i = 10; i <= 99; i++) {
      int digit = i % 10;
      if (digit == 0)
        continue;

      int denomBase = digit * 10;
      for (int j = 1; j <= 9; j++) {
        int denom = denomBase + j;
        if (denom == i)
          continue;

        if (((double) i) / ((double) denom) == ((double) (i / 10)) / ((double) j)) {
          System.out.println(i + "/" + denom + " = " + i / 10 + "/" + j);
        }
      }
    }
  }
}
