package com.euler;

import com.euler.util.MathExt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem23 {
  public static void main(String[] args) {
    List<Long> abundants = new ArrayList<>();
    for (long i = 1L; i < 28123; i++) {
      long sum = 0;
      for (Long divisor : MathExt.divisors(i))
        sum += divisor;
      if (sum > i)
        abundants.add(i);
    }

    Set<Long> abundantSums = new HashSet<>();
    for (Long a1 : abundants)
      for (Long a2 : abundants)
        abundantSums.add(a1 + a2);

    long sum = 0;
    for (long i = 1L; i < 28123; i++)
      if (!abundantSums.contains(i))
        sum += i;

    System.out.println(sum);
  }
}
