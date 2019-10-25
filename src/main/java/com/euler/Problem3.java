package com.euler;

class Problem3 {
  public static void main(String[] args) {
    long n = 600851475143L;
    for (long i = 2; i <= n / i; i++) {
      while (n % i == 0) {
        System.out.println(i);
        n /= i;
      }
    }

    System.out.println("Largest Factor: " + n);
  }
}
