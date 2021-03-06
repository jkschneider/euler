package com.euler;

import com.euler.util.PrimeTest;

class Problem58 {
  public static void main(String[] args) {
    double primes = 0;
    int diag = 1;
    int layer = 1;
    double ratio;
    do {
      for (int i = 0; i < 4; i++) {
        diag += layer * 2;
        if (PrimeTest.prime(diag))
          primes++;
      }
      ratio = primes / (layer * 4 + 1);
//			System.out.println("Ratio for layer " + layer + ": " + ratio);
      layer++;
    } while (ratio >= 0.1);
    layer--;

    System.out.println("Layer: " + layer);
    System.out.println("Ratio: " + ratio);
    System.out.println("Side length: " + (layer * 2 + 1));
  }
}
