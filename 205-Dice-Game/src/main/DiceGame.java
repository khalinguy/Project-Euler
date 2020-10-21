package main;

/*Problem 205. Dice Game https://projecteuler.net/problem=205
 * 
 * My approach to this problem:
 * - Peter has 9 dices of 4-side which means the total sum of dices thrown by Peter ranges from 1*9 to 4*9 = 9 to 36
 * - Colin has 6 dices of 6-side which means the total sum of dices thrown by Colin ranges from 1*6 to 6*6 = 6 to 36
 * - First, calculate the number of ways for each person rolls their dices that has sum equal to each value among [9-36] and [6-36], for P and C respectively.
 * - Next, calculate  the sum of all possible ways that Peter's total sum is larger than Colin's total sum. 
 * - The probability that Peter beats Colin is obtained by dividing the sum of all possible ways for the total number of possible rolls (independent events).
 * */

public class DiceGame {
	
	// Create two double arrays with the same size which is the total sum of dices thrown by Colin (larger range) for easier calculation
	double[] peterPDF = new double[36-6+1]; // 9-36
	double[] colinPDF = new double[36-6+1]; // 6-36
	
	// The total number of possible rolls for P and C
	double peterT = Math.pow(4, 9);
	double colinT = Math.pow(6, 6);
	
	public static void main(String[] args)  {
		System.out.println(new DiceGame().run());
	}
	
	public String run() {
		
		// The number of ways to achieve possible sums for Peter 
		for (int i = 1; i <= peterPDF.length; i++) {
			peterPDF[i-1] = ProbabilityAlgorithm.getWays(4,9,i + 5);
		}
		
		// The number of ways to achieve possible sums for Colin 
		for (int j = 1; j <= colinPDF.length; j++) {
			colinPDF[j-1] = ProbabilityAlgorithm.getWays(6,6,j + 5);
		}
		
		double total = 0;

		// The number of ways in which Peter's total sum is higher than Colin's total sum.  
		for (int c = 0; c < colinPDF.length; c++) {
			for (int p = c+1; p < peterPDF.length; p++) {
				total += peterPDF[p]*colinPDF[c];
			}
		}
		
		double prob = total/(peterT*colinT);
		
		return String.format("%.7f", prob);
	}
	
	
	
	
}
