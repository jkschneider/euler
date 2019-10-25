package com.euler;

import static java.lang.Math.*;

// brute force
public class Problem373 {
  public static void main(String[] args) {
    int N = 1200;
    int sum = 0;

    double rad = 0.0;
    for (long c = 1; c < N * 2; c++) {
      for (long b = c; b < N * 2; b++) { // b >= a to avoid duplicate
        long a;
        for (a = max(c, b); a < b + c; a++) { // c must satisfy triangle inequality
          rad = radius(a, b, c);
          if (rad > N)
            break;

          if (floor(rad) == rad && rad <= N && rad > 0) {
            sum += rad;
          }
        }
      }
    }

    System.out.println("sum = " + sum);
  }

  private static double radius(long a, long b, long c) {
    return (a * b * c) / sqrt((a + (b + c)) * (c - (a - b)) * (c + (a - b)) * (a + (b - c)));
  }
}
