package com.euler;

class Problem39 {
  public static void main(String[] args) {
    int maxSolutions = 0;
    int maxP = 0;
    for (int p = 0; p <= 1000; p++) {
      int solutions = 0;
      for (int a = 0; a < p; a++) {
        for (int b = 0; b < p - a - 1; b++) {
          int c = p - a - b;
          if (a * a + b * b == c * c)
            solutions++;
        }
      }

      if (solutions > maxSolutions) {
        maxSolutions = solutions;
        maxP = p;
      }
    }

    System.out.println(maxP + " solutions " + maxSolutions);
  }
}
