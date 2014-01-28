package com.euler.p55;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.euler.MathExt;

public class Problem55 {
    public static void main(String[] args) {
        Set<BigInteger> numbersNotLychrel = new HashSet<BigInteger>();
        Set<BigInteger> numbersLychrel = new HashSet<BigInteger>();
        
        for(int n = 1; n < 10000; n++) {
            if(numbersNotLychrel.contains(n))
                continue;
            
            BigInteger n0 = BigInteger.valueOf(n);
            Set<BigInteger> numbersInThisTest = new HashSet<BigInteger>();
            boolean lychrel = true;
            
            for(long i = 0; i < 50; i++) {
                BigInteger n1 = reversedDigits(n0);
                if(MathExt.isPalindrome(n0.add(n1))) {
//                    System.out.println(n + " with iterations " + (numbersInThisTest.size()+1));
                    numbersNotLychrel.addAll(numbersInThisTest);
                    lychrel = false;
                    break;
                }
                numbersInThisTest.add(n0);
                n0 = n1.add(n0);
            }
            
            if(lychrel) {
                System.out.println(n);
                numbersLychrel.add(BigInteger.valueOf(n));
            }
        }
        
        System.out.println(numbersLychrel.size());
    }
    
    public static BigInteger reversedDigits(BigInteger n) {
        return new BigInteger(new StringBuffer(n.toString()).reverse().toString());
    }
}
