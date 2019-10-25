package com.euler;

import com.euler.util.HexagonalGenerator;
import com.euler.util.PentagonalGenerator;

import java.util.HashSet;
import java.util.Set;

public class Problem45 {
  public static void main(String[] args) {
    Set<Long> triangles = new HashSet<Long>();
    for (long i = 285; i < 1000000; i++)
      triangles.add((i * (i + 1L)) / 2L);

    Set<Long> pentagonals = new HashSet<Long>(PentagonalGenerator.pentagonals(165, 1000000));
    Set<Long> hexagonals = new HashSet<Long>(HexagonalGenerator.hexagonals(143, 1000000));

    for (Long tri : triangles)
      if (pentagonals.contains(tri) && hexagonals.contains(tri))
        System.out.println(tri);
  }
}
