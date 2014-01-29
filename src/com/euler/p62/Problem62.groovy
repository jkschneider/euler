package com.euler.p62

import static java.lang.Math.*
import com.euler.PermutationGenerator

Set<String> first1000Cubes = (1..5000).collect { n -> (n*n*n).toString() }

int targetPermCount = 5

String permute(Long n, int[] positions) {
	String nStr = n.toString()
	StringBuffer permuted = new StringBuffer()
	for(int i = 0; i < positions.length; i++) {
		if(i == 0 && nStr[positions[i]] == '0')
			return null
		permuted.append(nStr[positions[i]])
	}
	return permuted.toString()
}

long time = System.currentTimeMillis()

nIter: for(Long i = 1000;; i++) {
	Long n = i*i*i
	println "Testing: ${i}^3 = $n"
	if(n > Math.pow(5000, 3))
		break;
	
	PermutationGenerator perm = new PermutationGenerator(n.toString().length())
	
	int permCount = 0
	Set<Long> tested = []
//	int permTested = 0
	
	while(perm.hasMore()) {
		def thisPerm = permute(n, perm.getNext())
		
		if(!tested.contains(thisPerm) && first1000Cubes.contains(thisPerm))
			permCount++
		tested.add(thisPerm)
		
//		if(perm.getTotal() - (++permTested) < targetPermCount)
//			break
		
		if(permCount == targetPermCount) {
			println n
			println "time: " + (System.currentTimeMillis() - time)
			break nIter
		}
	}
}