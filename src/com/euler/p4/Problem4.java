package com.euler.p4;

public class Problem4 {
    public static void main(String[] args) {
        int largestPalindrome = 0;
        
        for(int i = 100; i <= 999; i++) {
            for(int j = 100; j <= 999; j++) {
                String test = new Integer(i*j).toString();
                if(test.length() % 2 != 0)
                    continue;
                int mid = test.length() / 2;
                String firstHalf = test.substring(0, mid);
                StringBuffer secondBuffer = new StringBuffer(test.substring(mid));
                
                if(firstHalf.equals(secondBuffer.reverse().toString())) {
                    System.out.println(i*j);
                    if(i*j > largestPalindrome)
                        largestPalindrome = i*j;
                }
            }
        }
        
        System.out.println("Largest Palindrome: " + largestPalindrome);
    }
}
