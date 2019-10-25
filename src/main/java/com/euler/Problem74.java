package com.euler;

import com.euler.util.MathExt;

import java.util.ArrayList;
import java.util.List;

public class Problem74 {
  public static void main(String[] args) {
    int count = 0;

    for (Long i = 69L; i < 1000000; i++) {
      Long i0 = i;

      List<Long> nonRepeatingTerms = new ArrayList<Long>();

      while (!nonRepeatingTerms.contains(i0)) {
        nonRepeatingTerms.add(i0);

        String iStr = i0.toString();
        long sum = 0L;
        for (int j = 0; j < iStr.length(); j++)
          sum += MathExt.factorial(Integer.parseInt(iStr.substring(j, j + 1)));

        i0 = sum;
      }

      if (nonRepeatingTerms.size() == 60)
        count++;
    }

    System.out.println(count);
  }
}
