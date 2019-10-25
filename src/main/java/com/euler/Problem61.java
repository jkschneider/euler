package com.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem61 {
  static class Figurate {
    int p;
    FigurateType type;

    int left() {
      return p / 100;
    }

    int right() {
      return p % 100;
    }

  }

  enum FigurateType {
    Triangle, Square, Pentagonal, Hexagonal, Heptagonal, Octagonal;

    int iter(int n) {
      switch (this) {
        case Triangle:
          return (n * (n + 1)) / 2;
        case Square:
          return n * n;
        case Pentagonal:
          return (n * (3 * n - 1)) / 2;
        case Hexagonal:
          return n * (2 * n - 1);
        case Heptagonal:
          return (n * (5 * n - 3)) / 2;
        case Octagonal:
        default:
          return n * (3 * n - 2);
      }
    }
  }

  private static final FigurateType seedType = FigurateType.Octagonal; // fewest octagonal seeds of any type
  private static final FigurateType[] consideredTypes = FigurateType.values(); //new FigurateType[] { FigurateType.Triangle, FigurateType.Square, FigurateType.Pentagonal };

  private static final List<Figurate> seeds = new ArrayList<>();
  private static final Map<Integer, List<Figurate>> figuratesByLeft = new HashMap<>();
  private static final Map<Integer, List<Figurate>> figuratesByRight = new HashMap<>();

  private static void initFigurates() {
    for (FigurateType figurateType : consideredTypes) {
      for (int n = 2; ; n++) {
        Integer p = figurateType.iter(n);
        if (p > 1010 && p < 10000 && p % 100 > 9) {
          Figurate figurate = new Figurate();
          figurate.p = p;
          figurate.type = figurateType;

          if (figurateType.equals(seedType))
            seeds.add(figurate);

          Integer left = p / 100, right = p % 100;
          if (!figuratesByLeft.containsKey(left))
            figuratesByLeft.put(left, new ArrayList<>());
          if (!figuratesByRight.containsKey(right))
            figuratesByRight.put(right, new ArrayList<>());

          figuratesByLeft.get(left).add(figurate);
          figuratesByRight.get(right).add(figurate);
        }
        if (p >= 10000)
          break;
      }
    }
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    initFigurates();

    int N = consideredTypes.length;
    for (Figurate seed : seeds) {
      Figurate[] select = new Figurate[N];
      select[0] = seed;
      if (recurseFindNext(select, 1)) {
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
        return;
      }
    }

  }

  private static boolean recurseFindNext(Figurate[] select, int n) {
    List<Figurate> nexts = figuratesByLeft.get(select[n - 1].right());
    if (nexts == null) return false;

    nextFigurate:
    for (Figurate next : nexts) {
      for (int i = 0; i < n; i++) {
        if (next.type.equals(select[i].type) || next.p == select[i].p)
          continue nextFigurate;
      }

      select[n] = next;

      if (n == select.length - 1) {
        if (next.right() != select[0].left())
          continue;

        int sum = 0;
        for (Figurate f : select) {
          sum += f.p;
//					System.out.print(f.p + " ");
        }
//				System.out.println();
        System.out.println(sum);
        return true;
      } else if (recurseFindNext(select, n + 1))
        return true;
    }

    return false;
  }
}
