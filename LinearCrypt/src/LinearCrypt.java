/**
 * 
 * @author Trushank
 *
 */
public class LinearCrypt {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Substitution Table
		long org[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		long sub[] = { 8, 4, 2, 1, 12, 6, 3, 13, 10, 5, 14, 7, 15, 11, 9, 0 };

		// TextBook example
		// long sub[] = { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7
		// };
		long comb = (long) Math.pow(2,8);
		// Run for all possible X1 X2 X3 X4 Y1 Y2 Y3 Y4
		for (long i = 0; i < comb; i++) {
			if (i % 16 == 0)
				System.out.println();

			String biComb = Long.toBinaryString(i);

			// Pad 0s to front
			while (biComb.length() != 8)
				biComb = "0" + biComb;

			// Split for X and Y
			String biCombX = biComb.substring(0, 4);
			String biCombY = biComb.substring(4);

			int count = 0;
			for (int j = 0; j < 16; j++) {
				long a = 0;
				long b = 0;
				String x = new String();
				String y = new String();

				for (int q = 0; q < 4; q++) {
					if (biCombX.charAt(q) == '1') {
						long temp = 0;
						String tempS = Long.toBinaryString(org[j]);
						while (tempS.length() != 4)
							tempS = "0" + tempS;
						temp = Long.parseLong(Character.toString((tempS
								.charAt(q))));

						x += ("X:" + a + "^" + temp + "=");
						a = a ^ temp;
						x += (a + "\n");
					}
					if (biCombY.charAt(q) == '1') {
						long temp = 0;
						String tempS = Long.toBinaryString(sub[j]);
						while (tempS.length() != 4)
							tempS = "0" + tempS;
						temp = Long.parseLong(Character.toString((tempS
								.charAt(q))));
						y += ("Y:" + b + "^" + temp + "=");
						b = b ^ temp;
						y += (b + "\n");

					}

				}

				if (a == b) {
					count++;
				}
			}
			System.out.print(count + " ");
		}

	}

}
