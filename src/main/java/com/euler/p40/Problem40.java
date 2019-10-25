package com.euler.p40;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("serial")
public class Problem40 {
    public static void main(String[] args) {
        Queue<Integer> parts = new LinkedList<Integer>() {{ push(1000000); push(100000); push(10000); push(1000); push(100); push(10); }};
        
        int product = 1;
        int n = 1;
        int i = 1;
        while(!parts.isEmpty()) {
            int j = i;
            while(j != 0) {
                j /= 10;
                n++;
            }
            
            if(n-1 >= parts.peek()) {
                j = i;
                for(int k = 0; k < n - parts.peek() - 1; k++)
                  j /= 10;
                product *= j % 10;
                parts.poll();
            }
            
            i++;
        }
        
        System.out.println(product);
    }
}
