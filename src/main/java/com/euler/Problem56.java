package com.euler;

import java.math.BigInteger;

public class Problem56 {

  public static void main(String[] args) {
    int maxSum = 0;
    int digitCounts[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    BigInteger one = new BigInteger("1");
    for (BigInteger a = new BigInteger("1"); a.compareTo(new BigInteger("100")) <= 0; a = a.add(one)) {
      for (int b = 1; b <= 100; b++) {
        String digits = a.pow(b).toString();
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
          int digit = Integer.parseInt(digits.substring(i, i + 1));
          digitCounts[digit] += 1;
          sum += digit;
        }
        if (sum > maxSum) {
          maxSum = sum;
          System.out.println("New max: " + maxSum);
        }
      }
    }

    float denom = 0;
    float num = 0;
    for (int i = 1; i < 10; i++) {
      denom += digitCounts[i];
      num += digitCounts[i] * i;
      System.out.println("Frequency of " + i + ": " + digitCounts[i]);
    }

    System.out.println("Mean: " + (num / denom) + " out of " + denom + " samples");
  }
}
