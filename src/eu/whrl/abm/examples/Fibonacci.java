package eu.whrl.abm.examples;

import eu.whrl.abm.ABM;

public class Fibonacci implements ABM {
	public int iterations = 10000;
	public long[] results;
	
	public long n = 8000L;
	private final long checksum = -5778370123062214075L;
	
	/* 
	 * Place any code you want to use to setup your benchmark here
	 */
	public void prepare() {
		results = new long[iterations];
	}
	
	/* 
	 * Place any code that you want to be timed in your benchmark here
	 */
	public void run() {
		for (int i = 0; i < iterations; i++) {
			results[i] = runLongVersion();
		}
	}
	
	/*
	 * Check your benchmark's results, return true if everything went smoothly, false otherwise.
	 */
	public boolean verify() {
		for (int i = 0; i < iterations; i++) {
			if (results[i] != checksum) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * (NB: this doesn't actually produce the right result for values of n greater than 91.) 
	 */
	private long runLongVersion() {
		long first = 1;
		long second = 1;
		for (long i = 2; i < n; i++) {
			long temp = second;
			second = first + second;
			first = temp;
		}
		return second;
	}
	
	/*
	 * This is an accurate version of fibonacci for (all?) n
	 */
	/*private BigInteger runBigIntegerVersion() {
		BigInteger first = BigInteger.ONE;
		BigInteger second = BigInteger.ONE;
		for (long i = 2; i < bigIntegerPlaces; i++) {
			BigInteger temp = second;
			second = first.add(second);
			first = temp;
			if (second.compareTo(first) <= 0) {
				Log.e("ABM", "Fibonacci not being calculated correctly!");
			}
		}
		return second;
	}*/
	
	
}
