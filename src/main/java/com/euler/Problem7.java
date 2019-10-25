package com.euler;

/**
 * Sieve of Erastosthenes
 *
 * @author Schneider
 */
class Problem7 {
  private static final int N = 300000;

  public static void main(String[] args) {
    int nthCounter = 0;

    boolean[] sieve = new boolean[N + 1];
    for (int i = 0; i < N + 1; i++)
      sieve[i] = true;

    for (int i = 2; i < N / 2; i++) {
      if (sieve[i]) {
        if (++nthCounter == 10001) {
          System.out.println(i);
          return;
        }

        int j = 2;
        while (j * i <= N)
          sieve[j++ * i] = false;
      }
    }
  }
}
