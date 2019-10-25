package com.euler.p18;

import java.util.Collection;

public interface IWeightedVertex {
    public Collection<IWeightedVertex> connectedVertices();
    public long weight();
}
