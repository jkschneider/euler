package com.euler;

class Problem5 {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    long[] factors = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    long[] sequence = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    boolean allEqual = false;
    while (!allEqual) {
      allEqual = true;
      int leastIndex = 0;

      for (int k = 0; k < sequence.length; k++) {
        if (k > 0 && sequence[k] != sequence[k - 1])
          allEqual = false;
        if (sequence[k] < sequence[leastIndex])
          leastIndex = k;

      }

      if (!allEqual)
        sequence[leastIndex] = sequence[leastIndex] + factors[leastIndex];
    }

    System.out.println("Time to complete: " + (System.currentTimeMillis() - start) / 1000 + " seconds");
    System.out.println("LCM: " + sequence[0]);
  }
}
