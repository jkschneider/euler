package com.euler;

import com.euler.util.PermutationGenerator;

import java.util.Set;
import java.util.TreeSet;

class Problem24 {
  public static void main(String[] args) {
    Set<String> perms = new TreeSet<>();

    PermutationGenerator g = new PermutationGenerator(10);
    while (g.hasMore()) {
      int[] indices = g.getNext();
      StringBuilder b = new StringBuilder();
      for (int index : indices) b.append((char) ('0' + index));
      perms.add(b.toString());
    }

    int pos = 1;
    for (String perm : perms) {
      if (pos == 1000000)
        System.out.println(perm);
      pos++;
    }
  }
}
