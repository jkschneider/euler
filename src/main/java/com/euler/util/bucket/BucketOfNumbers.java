package com.euler.util.bucket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class BucketOfNumbers<P, N extends Number> {
  protected P bucket;
  protected Collection<N> numbers = new ArrayList<N>();

  public void setBucket(P bucket) {
    this.bucket = bucket;
  }

  public P getBucket() {
    return bucket;
  }

  public boolean add(N arg0) {
    return numbers.add(arg0);
  }

  public boolean addAll(Collection<? extends N> arg0) {
    return numbers.addAll(arg0);
  }

  public void clear() {
    numbers.clear();
  }

  public boolean contains(Object arg0) {
    return numbers.contains(arg0);
  }

  public boolean containsAll(Collection<?> arg0) {
    return numbers.containsAll(arg0);
  }

  public boolean isEmpty() {
    return numbers.isEmpty();
  }

  public Iterator<N> iterator() {
    return numbers.iterator();
  }

  public boolean remove(Object arg0) {
    return numbers.remove(arg0);
  }

  public boolean removeAll(Collection<?> arg0) {
    return numbers.removeAll(arg0);
  }

  public boolean retainAll(Collection<?> arg0) {
    return numbers.retainAll(arg0);
  }

  public int size() {
    return numbers.size();
  }

  public Object[] toArray() {
    return numbers.toArray();
  }

  public <T> T[] toArray(T[] arg0) {
    return numbers.toArray(arg0);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bucket == null) ? 0 : bucket.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BucketOfNumbers<?, ?> other = (BucketOfNumbers<?, ?>) obj;
    if (bucket == null) {
      if (other.bucket != null)
        return false;
    } else if (!bucket.equals(other.bucket))
      return false;
    return true;
  }
}
