package com.euler.p51;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.euler.MathExt.digits;

import com.euler.PrimeGenerator;

public class Problem51 {
    public static void main(String[] args) {
        int N = 8;
        
        List<Integer> primes = PrimeGenerator.primesLessThan(1000000);
        Map<String, Integer> buckets = new HashMap<String, Integer>();
        
        int i = 0;
        for(Integer p : primes) {
            for(int j = i+1; j < primes.size(); j++) {
                Integer q = primes.get(j);
                if(digits(p) != digits(q))
                    break;
                String pattern = differencePattern(p, q);
                if(pattern == null)
                    continue;
                
                int bucketCount = buckets.containsKey(pattern) ? buckets.get(pattern) : 0;
                buckets.put(pattern, ++bucketCount);
                
                if(bucketCount == N-1) {
                    System.out.println(pattern + " " + p);
                    return;
                }
            }
            buckets.clear();
            i++;
        }
    }
    
    private static String differencePattern(Integer p, Integer q) {
        String pStr = p.toString();
        String qStr = q.toString();

        if(pStr.length() != qStr.length())
            return null;
        
        boolean similarity = false;
        
        StringBuffer diffPattern = new StringBuffer();

        Character firstPDiff = null;
        Character firstQDiff = null;
        
        for(int i = 0; i < pStr.length(); i++) {
            char qChar = qStr.charAt(i);
            char pChar = pStr.charAt(i);

            if(pStr.charAt(i) == qChar) {
                diffPattern.append(qChar);
                similarity = true;
            }
            else if(firstPDiff != null && (qChar != firstQDiff || pChar != firstPDiff))
                return null;
            else {
                firstPDiff = pChar;
                firstQDiff = qChar;
                diffPattern.append("*");
            }
        }
        
//        System.out.println(pStr + ", " + qStr + " => " + diffPattern.toString());
        
        return similarity ? diffPattern.toString() : null;
    }
}
