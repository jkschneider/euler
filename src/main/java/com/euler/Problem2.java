package com.euler;

class Problem2 {
  private static long sum = 0;

  public static void main(String[] args) {
    fibonacciSum(50, 0, 1);
    System.out.println(sum);
  }

  private static long fibonacciSum(int n, long p0, long p1) {
    if (p1 % 2 == 0 && p1 <= 4000000)
      sum += p1;
    return n == 1 ? p1 : fibonacciSum(n - 1, p1, p0 + p1);
  }
}
