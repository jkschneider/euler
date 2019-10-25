package com.euler.p38;

import com.euler.MathExt;

public class Problem38 {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
            for(int T = 1; T < 1000000; T++) {
                StringBuffer concat = new StringBuffer();
                for(int n = 1; n <= i; n++) {
                    concat.append(new Integer(T*n).toString());
                }
                
                if(concat.length() == 9 && MathExt.isPandigital(Long.parseLong(concat.toString()))) {
                    System.out.println(i + ", " + T + ", " + concat.toString());
                }
            }
        }
    }
}
