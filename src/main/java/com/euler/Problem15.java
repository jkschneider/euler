package com.euler;

class Problem15 {
  private final static int SIZE = 20;

  public static void main(String[] args) {
    long[][] grid = new long[SIZE + 1][SIZE + 1];

    for (int i = 0; i <= SIZE; i++) {
      grid[0][i] = 1;
      grid[i][0] = 1;
    }

    for (int row = 1; row <= SIZE; row++)
      for (int col = 1; col <= SIZE; col++)
        grid[row][col] = grid[row - 1][col] + grid[row][col - 1];

    System.out.println(grid[SIZE][SIZE]);
  }
}
