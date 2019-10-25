package com.euler.util;

import java.util.ArrayList;
import java.util.List;

public class HexagonalGenerator {
  public static List<Long> firstNHexagonals(long N) {
    return hexagonals(1, N);
  }

  public static List<Long> hexagonals(long from, long to) {
    List<Long> hexagonals = new ArrayList<Long>();
    for (long i = from; i < to; i++)
      hexagonals.add(i * (2L * i - 1L));
    return hexagonals;
  }
}
