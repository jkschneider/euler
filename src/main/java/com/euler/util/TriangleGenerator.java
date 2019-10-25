package com.euler.util;

import java.util.ArrayList;
import java.util.List;

public class TriangleGenerator {

  public static List<Long> triangles(long from, long to) {
    List<Long> triangles = new ArrayList<>();
    for (long i = from; i < to; i++) {
      // we do this to prevent ourselves from overflowing the Long type too quickly...
      if (i % 2 == 0)
        triangles.add((i / 2) * (i + 1L));
      else
        triangles.add(i * ((i + 1L) / 2));
    }
    return triangles;
  }
}
