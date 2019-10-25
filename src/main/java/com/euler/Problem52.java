package com.euler;

import java.util.Arrays;

class Problem52 {
  public static void main(String[] args) {
    for (int x = 1; x < 1000000; x++) {
      boolean sameDigits = true;
      String digits = sortedDigits(x);
      for (int i = 2; i <= 6; i++) {
        if (!digits.equals(sortedDigits(i * x))) {
          sameDigits = false;
          break;
        }
      }

      if (sameDigits) {
        System.out.println(x);
        return;
      }
    }
  }

  private static String sortedDigits(Integer n) {
    char[] chars = n.toString().toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
