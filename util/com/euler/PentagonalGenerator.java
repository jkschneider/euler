package com.euler;

import java.util.ArrayList;
import java.util.List;

public class PentagonalGenerator {
    public static List<Long> firstNPentagonals(long N) {
        return pentagonals(1, N);
    }
    
    public static List<Long> pentagonals(long from, long to) {
        List<Long> pentagonals = new ArrayList<Long>();
        for(long i = from; i < to; i++)
            pentagonals.add((i*(3L*i-1L))/2L);
        return pentagonals;
    }
}
