package com.euler.p18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinaryNode implements IWeightedVertex {
  public BinaryNode left;
  public BinaryNode right;

  public long weight;

  @Override
  public Collection<IWeightedVertex> connectedVertices() {
    List<IWeightedVertex> connected = new ArrayList<IWeightedVertex>();
    if (left != null)
      connected.add(left);
    if (right != null)
      connected.add(right);
    return connected;
  }

  @Override
  public long weight() {
    return weight;
  }
}
