package com.euler;

import com.euler.util.PermutationGenerator;

import java.util.TreeSet;

public class Problem68 {
  int N = 5;

  public static void main(String[] args) {
    new Problem68().run();
  }

  public void run() {
    PermutationGenerator permGen = new PermutationGenerator(N * 2);

    TreeSet<String> solutions = new TreeSet<String>();

    int[] inners = new int[N + 1];
    int[] outers = new int[N];

    nextPerm:
    while (permGen.hasMore()) {
      int[] perm = permGen.getNext();

      for (int i = 0; i < N; i++) {
        inners[i] = perm[i] + 1;
        if (inners[i] == 10) continue nextPerm; // this would lead to a 17-digit string
        outers[i] = perm[i + N] + 1;
      }
      inners[N] = inners[0];

      int[][] groups = groups(inners, outers);
      if (isSolution(groups))
        solutions.add(digitString(groups));
    }

    System.out.println("solution = " + solutions.descendingIterator().next());
  }

  public int[][] groups(int[] inners, int[] outers) {
    int[][] groups = new int[N][3];
    for (int i = 0; i < N; i++)
      groups[i] = new int[]{outers[i], inners[i], inners[i + 1]};
    return groups;
  }

  public boolean isSolution(int[][] groups) {
    int[] totals = new int[N];
    for (int i = 0; i < N; i++)
      totals[i] = groups[i][0] + groups[i][1] + groups[i][2];

    for (int i = 0; i < N - 1; i++)
      if (totals[i] != totals[i + 1])
        return false;
    return true;
  }

  public String digitString(int[][] groups) {
    int indexOfSmallest = 0;
    int[] smallest = groups[0];
    outer:
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        if (smallest[j] == groups[i][j])
          continue;
        if (smallest[j] < groups[i][j])
          continue outer;
        break;
      }
      smallest = groups[i];
      indexOfSmallest = i;
    }

    StringBuffer digitString = new StringBuffer();
    for (int i = indexOfSmallest; i < N; i++)
      digitString.append(new Integer(groups[i][0]).toString() + groups[i][1] + groups[i][2]);
    for (int i = 0; i < indexOfSmallest; i++)
      digitString.append(new Integer(groups[i][0]).toString() + groups[i][1] + groups[i][2]);

    return digitString.toString();
  }
}
