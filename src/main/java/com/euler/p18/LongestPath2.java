package com.euler.p18;

import java.util.HashMap;
import java.util.Map;

public class LongestPath2 {
  public static long calculate(IWeightedVertex root) {
    Map<IWeightedVertex, Long> lengthTo = new HashMap<IWeightedVertex, Long>();
    lengthTo.put(root, root.weight());

    calculateRec(root, lengthTo);

    return lengthTo.get(root);
  }

  private static long calculateRec(IWeightedVertex v, Map<IWeightedVertex, Long> lengthTo) {
    Long maxLength = 0L;
    for (IWeightedVertex w : v.connectedVertices()) {
      Long length = lengthTo.get(w);
      if (length == null)
        length = calculateRec(w, lengthTo);

      if (maxLength < length)
        maxLength = length;
    }

    lengthTo.put(v, v.weight() + maxLength);
    return v.weight() + maxLength;
  }
}
