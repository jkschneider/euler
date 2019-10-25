package com.euler;

import com.euler.util.MathExt;

public class Problem36 {
  public static void main(String[] args) {
    long sum = 0;
    for (int n = 0; n < 100000000; n++) {
      if (MathExt.isPalindrome(n) && MathExt.isPalindrome(n, 2)) {
        sum += n;
        System.out.println(n);
      }
    }

    System.out.println("Sum: " + sum);
  }
}
