package com.euler.p90;

import java.util.ArrayList;
import java.util.List;

public class Problem90 {
	private static final String[] squares = new String[] { "01", "04", "09", "16", "25", "36", "49", "64", "81" };
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		List<List<Integer>> dicePossibilities = new ArrayList<List<Integer>>();
		for(int i1 = 0; i1 < 7; i1++) {
			for(int i2 = i1+1; i2 < 8; i2++) {
				for(int i3 = i2+1; i3 < 9; i3++) {
					for(int i4 = i3+1; i4 < 10; i4++) {
						List<Integer> die = new ArrayList<Integer>();
						for(int digit = 0; digit < 10; digit++) {
							if(digit != i1 && digit != i2 && digit != i3 && digit != i4)
								die.add(digit);
						}
						dicePossibilities.add(die);
					}
				}	
			}
		}
		
		int count = 0;
		for(int i = 0; i < dicePossibilities.size(); i++) {
			for(int j = i+1; j < dicePossibilities.size(); j++) {
				List<Integer> die1 = dicePossibilities.get(i);
				List<Integer> die2 = dicePossibilities.get(j);
				if(testSquares(die1, die2))
					count++;
			}
		}
		
		System.out.println("Time: " + (System.currentTimeMillis()-start) + "ms");
		System.out.println(count);
	}
	
	public static boolean testSquares(List<Integer> die1, List<Integer> die2) {
		for(String square : squares) {
			int digit1 = square.charAt(0)-48;
			int digit2 = square.charAt(1)-48;

			if(hasDigit(die1, digit1) && hasDigit(die2, digit2))
				continue;
			if(hasDigit(die2, digit1) && hasDigit(die1, digit2))
				continue;

			return false;
		}
		return true;
	}
	
	public static final boolean hasDigit(List<Integer> die, int digit) {
		if(die.contains(digit))
			return true;
		if(digit == 6 && die.contains(9))
			return true;
		if(digit == 9 && die.contains(6))
			return true;
		return false;
	}
}
