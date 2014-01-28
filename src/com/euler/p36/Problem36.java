package com.euler.p36;

import com.euler.MathExt;

public class Problem36 {
    public static void main(String[] args) {
        long sum = 0;
        for(int n = 0; n < 1000000; n++) {
            if(MathExt.isPalindrome(n) && MathExt.isPalindrome(n, 2)) {
                sum += n;
                System.out.println(n);
            }       
        }
        
        System.out.println("Sum: " + sum);
    }
}
