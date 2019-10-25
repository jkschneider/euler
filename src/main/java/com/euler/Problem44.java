package com.euler;

import com.euler.util.PentagonalGenerator;

import java.util.HashSet;
import java.util.Set;

public class Problem44 {
  public static void main(String[] args) {
    Set<Long> pents = new HashSet<Long>(PentagonalGenerator.firstNPentagonals(10000));

    long leastDif = Long.MAX_VALUE;

    for (Long a : pents) {
      for (Long b : pents) {
        if (pents.contains(a + b) && pents.contains(b - a)) {
          System.out.println(a + ", " + b + ", b - a = " + (b - a));
          if (b - a < leastDif)
            leastDif = b - a;
        }
      }
    }

    System.out.println(leastDif);
  }
}
