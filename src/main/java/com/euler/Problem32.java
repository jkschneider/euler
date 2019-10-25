package com.euler;

import com.euler.util.PermutationGenerator;

import java.util.HashSet;
import java.util.Set;

class Problem32 {
  public static void main(String[] args) {
    PermutationGenerator gen = new PermutationGenerator(9);

    Set<Integer> products = new HashSet<>();

    int[] indices;
    while (gen.hasMore()) {
      indices = gen.getNext();

      int p0 = ((indices[0] + 1) * 10) + indices[1] + 1;
      int p1 = ((indices[2] + 1) * 100) + ((indices[3] + 1) * 10) + indices[4] + 1;
      int product = ((indices[5] + 1) * 1000) + ((indices[6] + 1) * 100) + ((indices[7] + 1) * 10) + indices[8] + 1;

      if (p0 * p1 == product) {
        System.out.println(p0 + "+" + p1 + "=" + product);
        products.add(product);
      }

      p0 = indices[0] + 1;
      p1 = ((indices[1] + 1) * 1000) + ((indices[2] + 1) * 100) + ((indices[3] + 1) * 10) + indices[4] + 1;

      if (p0 * p1 == product) {
        System.out.println(p0 + "+" + p1 + "=" + product);
        products.add(product);
      }
    }

    System.out.println(products);

    int sum = 0;
    for (Integer product : products)
      sum += product;
    System.out.println(sum);
  }
}
