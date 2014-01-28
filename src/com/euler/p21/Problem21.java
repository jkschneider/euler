package com.euler.p21;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Problem21 {
    public static void main(String[] args) {
        Map<Integer, Integer> f = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < 10000; i++) {
            int sum = 0;
            for(int div = 1; div <= i/2; div++) {
                if(i % div == 0)
                    sum += div;
            }
            f.put(i, sum);
        }
        
        int sum = 0;
        for(Entry<Integer, Integer> f_i : f.entrySet()) {
            Integer a = f_i.getKey(); 
            Integer b = f_i.getValue();
            if(a.equals(f.get(b)) && !a.equals(b)) {
                System.out.println(a + ", " + b);
                sum += a;
            }
        }
        
        System.out.println("Sum: " + sum);
    }
}
