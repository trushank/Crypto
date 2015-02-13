import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * RSADecrypt.java
 * Decrypts given RSA cypher text based on n and public key
 * @author Trunk Date: Sep 25, 2013
 */

/**
 * 
 * RSADecrypt
 * @author Trunk
 * Date: Sep 25, 2013
 */
public class RSADecrypt {
    public static void main(String args[]) {

	try {
	    int n = Integer.parseInt(args[0]);	//inputing N
	    int b = Integer.parseInt(args[1]);	//input public key
	    int factor = 0;
	    int phiN;
	    int inverse = 0;
	    Scanner src = new Scanner(new File(args[2]));
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    
	    //Stores the cyphertext
	    ArrayList<Integer> input = new ArrayList<Integer>();
	    while (src.hasNext()) {
		input.add(src.nextInt());
	    }
	    src.close();

	    //Compute factor of n
	    for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
		if (n % i == 0)
		    factor = i;
	    }
	    
	    //if n is prime
	    if (factor == 0) {
		System.err.println("Error: N is prime");
		System.exit(0);
	    }
	    System.out.println("Factor:"+factor);
	    
	    //Compute phi(n)
	    phiN = (factor - 1) * (n / factor - 1);
	    System.out.println("PhiN:"+phiN);
	    
	    //Compute inverse
	    for (int i = 1; i < phiN; ++i) {
		if (!((b * i) % phiN == 1)) {
		    continue;
		} else {
		    inverse = i;
		    break;
		}
	    }
	    System.out.println("Inverse:"+inverse);
	    
	    //Convert Inverse to binary
	    String binInv = Integer.toBinaryString(inverse);
	    
	    //Stores result temporarily
	    temp = new ArrayList<Integer>();
	    
	    // Square Multiply
	    for (int i = 0; i < input.size(); i++) {
		int temp1 = 1;
		for (int j = 0; j < binInv.length(); j++) {
		    temp1 = (temp1 * temp1) % n;
		    if (binInv.charAt(j) == '1') {
			temp1 = (input.get(i) * temp1) % n;
		    }
		}
		temp.add(temp1);
	    }
	    
	    
	    String result = new String();	//final result
	    int s = 26 * 26;
	    
	    //Decoding the chars
	    for (int i = 0; i < temp.size(); i++) {
		int z = temp.get(i);
		char p = (char) (((z - (z % s)) / s)+97);
		char q = (char) (((((z % s)) - (z % 26)) / 26)+97);
		char r = (char)( (z % 26)+97);
		result = result + p +q + r;

	    }
	    
	    //Printing result
	    System.out.println(result);
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

    }

}
