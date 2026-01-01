/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		//// Uncomment the version of binomial that you want to test
 
		// Testing the basic binomial implementation:
    	//System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	public static long binomial1(long n, long k) { 
	if (k > n) return 0;
	if (k == 0 || n == 0) return 1;
	return binomial1(n - 1, k) + binomial1(n - 1, k - 1);
	 }
	
	// Computes the Binomial function, efficiently
	public static long binomial(long n, long k) {
		//// This function creates a 2D array, say memo, 
		//// and then initializes all its elements to -1.
		//// It then calls binomial(n, k, memo), which does all the heavy lifiting.
		//// Replace the following statement with your code.
		int ni = (int) n;
		int ki = (int) k;
		long[][] memo = new long[ni + 1][ki + 1];
		for (int i = 0; i <= ni; i++) {
			for (int j = 0; j <= ki; j++) {
					memo[i][j] = -1;
			}
	}
	return binomial(ni, ki, memo);
}
	private static long binomial(int n, int k, long[][] memo) {
		if (memo[n][k] != -1) {
			return memo[n][k];
		}
		// Base case
		if ((k > n)) {
		   	memo[n][k] = 0; 
		   	return 0;
		}
		// Another base case
		if (k == 0 || k == n) {
			memo[n][k] = 1;
			return 1;
	}	
		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}



}