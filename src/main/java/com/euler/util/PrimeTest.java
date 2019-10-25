package com.euler.util;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class PrimeTest {
  private static final BigInteger TWO = new BigInteger("2");
  private static final BigInteger THREE = new BigInteger("3");
  private static final BigInteger SIX = new BigInteger("6");

  public static boolean prime(long n) {
    return prime(BigInteger.valueOf(n));
  }

  public static boolean prime(BigInteger n) {
    if (n.equals(TWO) || n.equals(THREE))
      return true;
    if (n.mod(TWO).equals(ZERO) || n.mod(THREE).equals(ZERO))
      return false;
    if (!n.isProbablePrime(10))
      return false;

    BigInteger mMax = integralSqrt(n);
    BigInteger k = ONE;
    for (BigInteger test; (test = k.multiply(SIX).subtract(ONE)).compareTo(mMax) <= 0; k = k.add(ONE)) {
      if (n.mod(test).equals(ZERO)) // 6k-1
        return false;
      if (n.mod(test.add(TWO)).equals(ZERO)) // 6k-1
        return false;
    }

    return true;
  }

  private static BigInteger integralSqrt(BigInteger n) {
    BigInteger a = ONE;
    BigInteger b = n.shiftRight(5).add(new BigInteger("8"));
    while (b.compareTo(a) >= 0) {
      BigInteger mid = a.add(b).shiftRight(1);
      if (mid.multiply(mid).compareTo(n) > 0)
        b = mid.subtract(ONE);
      else
        a = mid.add(ONE);
    }
    return a.subtract(ONE);
  }
}
