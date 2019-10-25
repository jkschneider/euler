package com.euler;

class Problem28 {
  public static void main(String[] args) {
    int sum = 1; // center of spiral
    int d = 1;
    for (int i = 2; i <= (1001 - 1); i += 2) {
      for (int j = 0; j < 4; j++) {
        d += i;
        System.out.println(d);
        sum += d;
      }
    }

    System.out.println(sum);
  }
}
