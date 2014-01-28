package com.euler.bucket;

public class BucketOfIntegers<Q> extends BucketOfNumbers<Q, Integer> {
    public int sum() {
        int sum = 0;
        for(Integer n : numbers)
            sum += n;
        return sum;
    }
}
