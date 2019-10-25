package com.euler;

class Problem30 {
  public static void main(String[] args) {
    int totalSum = 0;
    for (int i = 2; i < 236196; i++) {
      String iStr = Integer.toString(i);
      int sum = 0;
      for (int j = 0; j < iStr.length(); j++)
        sum += Math.pow(Integer.parseInt(iStr.substring(j, j + 1)), 5);

      if (sum == i) {
        System.out.println(i);
        totalSum += i;
      }
    }

    System.out.println("Sum: " + totalSum);
  }
}
