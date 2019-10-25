package com.euler;

public class Problem6 {
  final static long N = 100;

  public static void main(String[] args) {
    long sumOfSquares = 0;
    for (long i = 1; i <= N; i++)
      sumOfSquares += i * i;

    long squareOfSums = N * (N + 1) / 2;
    squareOfSums = squareOfSums * squareOfSums;

    System.out.println(squareOfSums - sumOfSquares);
  }
}
