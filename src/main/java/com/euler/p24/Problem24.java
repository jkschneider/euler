package com.euler.p24;

import java.util.Set;
import java.util.TreeSet;

import com.euler.PermutationGenerator;

public class Problem24 {
    public static void main(String[] args) {
        Set<String> perms = new TreeSet<String>();
        
        PermutationGenerator g = new PermutationGenerator(10);
        while(g.hasMore()) {
            int indices[] = g.getNext();
            StringBuffer b = new StringBuffer();
            for(int i = 0; i < indices.length; i++)
                b.append((char) ('0' + indices[i]));
            perms.add(b.toString());
        }
        
        int pos = 1;
        for(String perm : perms) {
            if(pos == 1000000)
                System.out.println(perm);;
            pos++;
        }
    }
}
