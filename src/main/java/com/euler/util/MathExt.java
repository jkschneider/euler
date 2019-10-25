package com.euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MathExt {
    public static long gcd(long a, long b) {
        if(a == 0)
            return b;
        while(b != 0) {
            if(a > b)
                a -= b;
            else
                b -=a;
        }
        return a;
    }
    
    public static long factorial(long N) {
        if(N == 0)
            return 1;
        long fac = N;
        for(long n = N-1; n > 1; n--)
            fac *= n;
        return fac;
    }

    public static BigInteger factorialBig(long N) {
        if(N == 0)
            return BigInteger.valueOf(1L);
        BigInteger fac = BigInteger.valueOf(N);
        for(long n = N-1; n > 1; n--)
            fac = fac.multiply(BigInteger.valueOf(n));
        return fac;
    }
    
    public static boolean isPalindrome(BigInteger N) {
        return isPalindrome(N.toString());
    }

    public static boolean isPalindrome(long N) {
        return isPalindrome(N, 10);
    }
    
    public static boolean isPalindrome(long N, int base) {
        if(base != 2 && base != 10)
            throw new IllegalArgumentException("isPalindrome(..) only implemented for base 10 and 2");
        return isPalindrome(base == 10 ? Long.toString(N) : Long.toBinaryString(N));
    }
    
    private static boolean isPalindrome(String test) {
        int mid = test.length() / 2;
        String firstHalf = test.substring(0, mid);
        
        if(test.length() % 2 != 0)
            mid++;
        StringBuffer secondBuffer = new StringBuffer(test.substring(mid));
        
        return firstHalf.equals(secondBuffer.reverse().toString());
    }
    
    public static boolean isPandigital(Long N) {
        String n = N.toString();
        if(n.length() > 9)
            return false;
        for(char d = '1'; d < '1' + n.length(); d++)
            if(n.indexOf(d) < 0)
                return false;
        return true;
    }
    
    public static List<Long> divisors(Long N) {
        List<Long> divisors = new ArrayList<Long>();
        divisors.add(1L);
        
        for(long i = 2L; i <= N/2; i++)
            if(N % i == 0)
                divisors.add(i);
        
        return divisors;
    }
    
    public static int digits(Integer integer) {
        return integer.toString().length();
    }
}
