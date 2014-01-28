package com.euler.p373;

import static java.lang.Math.floor;

import static java.lang.Math.max;

import static java.lang.Math.sqrt;

public class Problem373 {
	public static void main(String[] args) {
		int N = 100;
		int sum = 0;

		double rad = 0.0;
		for (int c = 1;; c++) {
			int cCountWithRadiusLessThanN = 0;
			for (int b = c;; b++) { // b >= a to avoid duplicate
				int bCountWithRadiusLessThanN = 0;
				int a;
				for (a = max(c, b); a < b + c; a++) { // c must satisfy triangle inequality
					rad = radius(a, b, c);
					if (rad > N)
						break;
					
					bCountWithRadiusLessThanN++;
					cCountWithRadiusLessThanN++;
					
					if (floor(rad) == rad) {
						System.out.print(c + ", " + b + ", " + a + " = ");
						System.out.println(rad);
						sum += rad;
					}
				}
				if(bCountWithRadiusLessThanN == 0) {
//					System.out.println("RADIUS MAXED AT: " + c + ", " + b + ", " + a + " = " + rad);
					break;
				}
			}
			if(cCountWithRadiusLessThanN == 0) break;
		}

		System.out.println("sum = " + sum);
	}

	private static double radius(int a, int b, int c) {
		double T_area = 0.25 * sqrt((a + (b + c)) * (c - (a - b))
				* (c + (a - b)) * (a + (b - c)));
		return ((double) a / 4 * b * c) / T_area;
	}
}
