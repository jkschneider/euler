package com.euler;

class Problem81 {
  private static final int SIZE = 5;

  public static void main(String[] args) {
    long[] sums = new long[grid.length];
    System.arraycopy(grid, 0, sums, 0, grid.length);

    for (int row = 1; row < SIZE; row++) {
      for (int col = 1; col < SIZE; col++) {
        sums[row * SIZE + col] += sums[(row - 1) * SIZE + col - 1];
        System.out.print(sums[row * SIZE + col] + " ");
      }
      System.out.println();
    }

    // follow the least of down or right to get the answer
    int leastPath = 0;
    int row = 0;
    int col = 0;
    while (row < SIZE && col < SIZE) {
      System.out.println(grid[row * SIZE + col]);
      leastPath += grid[row * SIZE + col];
      if (row == SIZE - 1 || sums[(row + 1) * SIZE + col] > sums[row * SIZE + col + 1])
        col++;
      else
        row++;
    }
//        leastPath += grid[SIZE*SIZE-1];

    System.out.println(leastPath);
  }

  private static final long[] grid = {
    131, 673, 234, 103, 18,
    201, 96, 342, 965, 150,
    630, 803, 746, 422, 111,
    537, 699, 497, 121, 956,
    805, 732, 524, 37, 331,
  };

}
