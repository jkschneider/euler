package com.euler.p62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;


public class Problem62 {
	public static void main(String[] args) {
		ListMultimap<String, Long> groupedCubes = ArrayListMultimap.create();

		int totalPerms = 5;

		Joiner joiner = Joiner.on("");
		
		int digits = 3;
		nIter: for(Long n = 100L;; n++) {
			Long cube = n*n*n;
			
			if(cube.toString().length() > digits) {
				digits = cube.toString().length();
				
				for(Entry<String, Collection<Long>> cubeGroup : groupedCubes.asMap().entrySet()) {
					System.out.println(cubeGroup.getKey() + " " + cubeGroup.getValue().size());
					if(cubeGroup.getValue().size() >= totalPerms) {
						List<Long> sortedValues = new ArrayList(cubeGroup.getValue());
						Collections.sort(sortedValues);
						
						System.out.println("solution = " + sortedValues);
						break nIter;
					}
				}
				
				groupedCubes.clear();
			}
			
			String[] strDigits = cube.toString().split("");
			Arrays.sort(strDigits);
			groupedCubes.put(joiner.join(strDigits), cube);
		}
	}
}


