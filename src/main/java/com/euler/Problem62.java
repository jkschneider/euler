package com.euler;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;


public class Problem62 {
  public static void main(String[] args) {
    ListMultimap<String, Long> groupedCubes = ArrayListMultimap.create();

    int totalPerms = 5;
    Long least = null;

    Joiner joiner = Joiner.on("");

    int digits = 3;
    for (long n = 100L; ; n++) {
      Long cube = n * n * n;

      if (cube.toString().length() > digits) {
        digits = cube.toString().length();

        for (Entry<String, Collection<Long>> cubeGroup : groupedCubes.asMap().entrySet()) {
          if (cubeGroup.getValue().size() >= totalPerms) {
            Long leastCandidate = cubeGroup.getValue().iterator().next();
            if (least == null || least >= leastCandidate)
              least = leastCandidate;
          }
        }

        if (least != null) {
          System.out.println("solution = " + least);
          return;
        }

        groupedCubes.clear();
      }

      String[] strDigits = cube.toString().split("");
      Arrays.sort(strDigits);
      groupedCubes.put(joiner.join(strDigits), cube);
    }
  }
}
