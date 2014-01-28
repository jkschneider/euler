package com.euler.p14;

public class Problem14 {
    public static void main(String[] args) {
        int maxLength = 1;
        long maxI = 1;
        
        for(long i = 13; i < 1000000; i++) {
            long cursor = i;
            int chainLength = 1;
            while(cursor != 1) {
                if(cursor % 2 == 0)
                    cursor = cursor / 2;
                else
                    cursor = 3*cursor + 1;
                chainLength++;
            }
            
            if(chainLength > maxLength) {
                maxLength = chainLength;
                maxI = i;
            }
        }
        
        System.out.println(maxI);
    }
}
