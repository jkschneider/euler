package com.euler.p34;

import com.euler.MathExt;

public class Problem34 {
    
    public static void main(String[] args) {
        long ceiling = 0;
        
        long nineFac = MathExt.factorial(9L);
        for(long i = 0L; i < 25L; i++) {
            String digits = new Long(i*nineFac).toString();
            
            if(i > digits.length()) {
                System.out.println(i + ", " + digits.length() + ", " + i*nineFac);
                ceiling = i*nineFac;
                break;
            }
        }
        
        for(Long i = 0L; i < ceiling; i++) {
            String iStr = i.toString();
            long sum = 0L;
            for(int j = 0; j < iStr.length(); j++)
                sum += MathExt.factorial(Integer.parseInt(iStr.substring(j, j+1)));
            if(sum == i)
                System.out.println(i);
            
            if(i == 169)
                System.out.println("169: " + sum);
        }
    }
}
