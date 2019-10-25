package com.euler.p66;

import static java.lang.Math.*;

public class Problem66 {
    public static void main(String[] args) {
        double D = 1000;
        
        long maxX = 0;
        
        for(int d = 1; d <= D; d++) {
            double sqrtD = Math.sqrt(d);
            if(floor(sqrtD) == sqrtD)
                continue;
            
            for(long y = d;; y++) {
                double x = Math.sqrt(d*y*y + 1);
                if(floor(x) == x) {
                    if(x > maxX)
                        maxX = (long) x;
                    System.out.println("d = " + d + ", x = " + (long) x + ", y = " + (long) y);
                    break;
                }
            }
        }
        
        System.out.println("solution = " + maxX);
    }
}
