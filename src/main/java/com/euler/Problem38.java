package com.euler;

import com.euler.util.MathExt;

class Problem38 {
  public static void main(String[] args) {
    for (int i = 1; i <= 9; i++) {
      for (int T = 1; T < 1000000; T++) {
        StringBuilder concat = new StringBuilder();
        for (int n = 1; n <= i; n++) {
          concat.append(Integer.toString(T * n));
        }

        if (concat.length() == 9 && MathExt.isPandigital(Long.parseLong(concat.toString()))) {
          System.out.println(i + ", " + T + ", " + concat.toString());
        }
      }
    }
  }
}
