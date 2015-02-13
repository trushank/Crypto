import java.math.BigInteger;
import java.util.*;

public class MillerRabin {

	public static void main(String[] args) {
		// Stores 10 hishest errors
		ArrayList<Double> dlist = new ArrayList<Double>();
		ArrayList<Integer> ilist = new ArrayList<Integer>();

		// Run from 91000 to 96000
		for (int i = 91001; i < 96000; i = i + 2) {
			// find errorOfMR for every i
			double res = errorOfMR(i);

			// Check the array list to find lowest error and replace with new
			// one
			if (dlist.size() < 10) {
				dlist.add(res);
				ilist.add(i);
			} else {
				double q = dlist.get(0);
				int max = 0;
				for (int x = 1; x < 10; x++) {
					if (dlist.get(x) < q) {
						max = x;
						q = dlist.get(x);
					}
				}
				if (q < res) {
					dlist.remove(max);
					dlist.add(res);
					ilist.remove(max);
					ilist.add(i);
				}
			}
		}

		// Display Sorted result
		for (int i = 0; i < dlist.size(); i++) {
			int max = 0;
			for (int j = 0; j < dlist.size(); j++) {
				if (dlist.get(max) < dlist.get(j))
					max = j;
			}
			System.out.println("Number: " + ilist.get(max) + "ErrorMR: "
					+ dlist.get(max));
			dlist.remove(max);
			dlist.add(max, 0.0);
		}

	}

	// finds the error of MR
	private static double errorOfMR(int n) {
		int count = 0;
		// check if it is prime
		boolean isPrim = isPrime(n);

		BigInteger mynum = new BigInteger(Integer.toString(n));
		// call MR from 1 to n-1
		for (int i = 1; i <= n - 1; i++) {
			if (isPrim != millerRabin(mynum, i)) {
				count++;
			}
		}
		// calculate error
		return (double) count / (n - 1);
	}

	// checks if number is prime
	private static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i < n / 2; i = i + 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// Calculates MR
	private static boolean millerRabin(BigInteger n, int r) {

		BigInteger temp = BigInteger.valueOf(r);

		// Check if temp is factor of n
		if (!n.gcd(temp).equals(BigInteger.ONE))
			return false;

		BigInteger base = n.subtract(BigInteger.ONE);
		BigInteger TWO = new BigInteger("2");

		// find the biggest power of two that divides evenly into n-1.
		int k = 0;
		while ((base.mod(TWO)).equals(BigInteger.ZERO)) {
			base = base.divide(TWO);
			k++;
		}

		BigInteger currentValue = temp.modPow(base, n);

		// if curValue is one then it is prime
		if (currentValue.equals(BigInteger.ONE))
			return true;

		// Squaring to check if it gives -1
		for (int i = 0; i < k; i++) {

			if (currentValue.equals(n.subtract(BigInteger.ONE)))
				return true;
			else
				currentValue = currentValue.modPow(TWO, n);
		}

		// number is composite
		return false;
	}
}