package eu.whrl.abm.examples;

import java.math.BigInteger;

import android.util.Log;
import eu.whrl.abm.ABM;

public class Fibonacci implements ABM {
	public long bigIntegerPlaces = 65536L;
	public BigInteger bigIntegerResult = null;
	
	public long longPlaces = 80000000L;
	public long longResult = 0;
	
	/* 
	 * Place any code you want to use to setup your benchmark here
	 */
	public void prepare() {
		
	}
	
	/* 
	 * Place any code that you want to be timed in your benchmark here
	 */
	public void run() {
		runLong();
	}
	
	private void runBigInteger() {
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
		bigIntegerResult = second;
	}
	
	/*
	 * (NB: this doesn't actually produce the right result for values of n greater than 91.) 
	 */
	private void runLong() {
		long first = 1;
		long second = 1;
		for (long i = 2; i < longPlaces; i++) {
			long temp = second;
			second = first + second;
			first = temp;
		}
		longResult = second;
	}
}
