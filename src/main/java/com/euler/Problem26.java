package com.euler;

import java.util.ArrayList;
import java.util.List;

class Problem26 {
  public static void main(String[] args) {
    int maxCycle = 0;
    int maxCycleD = 0;

    for (int d = 2; d <= 1000; d++) {
      // fraction 1/d
      int numer = 1;
      while (numer < d) numer *= 10;

      List<Integer> remainders = new ArrayList<>();

      int remain = numer % d;
      while (!remainders.contains(remain)) {
        remainders.add(remain);
        remain *= 10;
        remain = remain % d;
      }

      int cycleLen = remainders.size() - remainders.indexOf(remain);
      if (cycleLen > maxCycle) {
        maxCycle = cycleLen;
        maxCycleD = d;
      }
    }

    System.out.println(maxCycleD + " with length " + maxCycle);
  }
}
