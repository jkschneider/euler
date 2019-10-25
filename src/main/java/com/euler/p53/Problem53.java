package com.euler.p53;

import static com.euler.MathExt.factorialBig;

import java.math.BigInteger;

public class Problem53 {
    public static void main(String[] args) {
        int totalExceeding1Million = 0;
        BigInteger threshhold = BigInteger.valueOf(1000000L);

        for(int n = 2; n <= 100; n++) {
            for(int r = 1; r <= n; r++) {
                if(factorialBig(n).divide((factorialBig(r).multiply(factorialBig(n-r)))).compareTo(threshhold) > 0) {
//                    System.out.println(n);
                    totalExceeding1Million++;
                }
            }
        }
        
        System.out.println(totalExceeding1Million);
    }
}
