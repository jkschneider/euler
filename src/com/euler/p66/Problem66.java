package com.euler.p66;

public class Problem66 {
    public static void main(String[] args) {
        double D = 1000;
        
        int maxX = 0;
        
        for(int d = 778; d <= D; d++) {
            double sqrtD = Math.sqrt(d);
            if(sqrtD == (int) sqrtD)
                continue;
            
            double y = d;
            while(true) {
                double x = Math.sqrt(d*y*y + 1);
                if(x == (int) x) {
                    if(x > maxX)
                        maxX = (int) x;
                    System.out.println("d = " + d + ", x = " + (int) x + ", y = " + (int) y);
                    break;
                }
                y++;
            }
        }
        
        System.out.println(maxX);
    }
}
