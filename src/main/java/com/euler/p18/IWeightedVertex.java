package com.euler.p18;

import java.util.Collection;

interface IWeightedVertex {
  Collection<IWeightedVertex> connectedVertices();

  long weight();
}
