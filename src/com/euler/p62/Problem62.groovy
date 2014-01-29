package com.euler.p62

import static java.lang.Math.*
import com.euler.PermutationGenerator

Long permute(Long n, int[] positions) {
	String nStr = n.toString()
	StringBuffer permuted = new StringBuffer()
	for(int i = 0; i < positions.length; i++) {
		if(i == 0 && nStr[positions[i]] == '0')
			return null
		permuted.append(nStr[positions[i]])
	}
	return Long.parseLong(permuted.toString())
}

int targetPermCount = 5

nIter: for(Long i = 100;; i++) {
	Long n = i*i*i
	println "Testing: " + n
	PermutationGenerator perm = new PermutationGenerator(n.toString().length())
	
	int permCount = 0
	Set<Long> tested = []
	
	while(perm.hasMore()) {
		Long cube = permute(n, perm.getNext())
		if(!cube || tested.contains(cube)) continue
		
		tested.add(cube)
		double cubeRoot = Math.cbrt(cube)
		if(floor(cubeRoot) == cubeRoot)
			permCount++
		if(permCount == targetPermCount) {
			println n
			break nIter
		}
	}
}