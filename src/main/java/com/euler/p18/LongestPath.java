package com.euler.p18;

import java.util.HashMap;
import java.util.Map;

public class LongestPath {
  public static int verticesVisited = 0;

  public static long calculate(IWeightedVertex root) {
    Map<IWeightedVertex, Long> lengthTo = new HashMap<IWeightedVertex, Long>();
    lengthTo.put(root, root.weight());

    calculateRec(root, lengthTo);

    Long maxValue = 0L;
    for (Long length : lengthTo.values())
      if (maxValue < length)
        maxValue = length;

    return maxValue;
  }

  // FIXME this works only on binary trees... more complex directed acyclic
  // graphs (DAGs) will require topological sorting first
  private static void calculateRec(IWeightedVertex v, Map<IWeightedVertex, Long> lengthTo) {
    if (verticesVisited % 1000000 == 0)
      System.out.println(verticesVisited + " vertices visited");

    for (IWeightedVertex w : v.connectedVertices()) {
      Long lengthToW = lengthTo.get(w);
      Long lengthToV = lengthTo.get(v);

      if (lengthToW == null || lengthToW <= lengthToV + w.weight())
        lengthTo.put(w, lengthToV + w.weight());

      verticesVisited++;
      calculateRec(w, lengthTo);
    }
  }
}
