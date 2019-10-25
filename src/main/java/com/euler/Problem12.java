package com.euler;

import com.euler.util.TriangleGenerator;

import java.util.List;

public class Problem12 {
  public static void main(String[] args) {
    int totalDivisors[] = new int[1000];

    int thousand = 11;
    while (true) {
      System.out.println("Checking " + thousand + ",000" + "-" + (thousand + 1) + ",000");

      for (int i = 0; i < totalDivisors.length; i++)
        totalDivisors[i] = 1;

      List<Long> triangles = TriangleGenerator.triangles(thousand * 1000, (thousand + 1) * 1000);
      int firstTriInPlay = 0;

      for (long n = 2L; n <= triangles.get(triangles.size() - 1) / 2; n++) {
        for (int i = firstTriInPlay; i < triangles.size(); i++) {
          long triangle = triangles.get(i);
          if (n > triangle / 2) {
            firstTriInPlay++;
            continue;
          }

          if (triangle % n == 0) {
            totalDivisors[i]++;
            if (triangle == 76576500)
              System.out.println(totalDivisors[i]);

            if (totalDivisors[i] >= 500) {
              System.out.println(triangle);
              return;
            }
          }
        }
      }
      thousand++;
    }
  }
}
