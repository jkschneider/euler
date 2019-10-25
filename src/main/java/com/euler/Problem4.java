package com.euler;

class Problem4 {
  public static void main(String[] args) {
    int largestPalindrome = 0;

    for (int i = 100; i <= 999; i++) {
      for (int j = 100; j <= 999; j++) {
        String test = Integer.toString(i * j);
        if (test.length() % 2 != 0)
          continue;
        int mid = test.length() / 2;
        String firstHalf = test.substring(0, mid);
        StringBuilder secondBuffer = new StringBuilder(test.substring(mid));

        if (firstHalf.equals(secondBuffer.reverse().toString())) {
          System.out.println(i * j);
          if (i * j > largestPalindrome)
            largestPalindrome = i * j;
        }
      }
    }

    System.out.println("Largest Palindrome: " + largestPalindrome);
  }
}
