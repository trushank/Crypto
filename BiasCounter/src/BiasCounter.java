import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class BiasCounter.
 */
public class BiasCounter {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		computeBias("s1.txt");
		computeBias("s2.txt");
		computeBias("s3.txt");
		computeBias("s4.txt");
		computeBias("s5.txt");
		computeBias("s6.txt");
		computeBias("s7.txt");
		computeBias("s8.txt");
		
		}
	
/**
 * Compute bias.
 *
 * @param file the file
 * @throws FileNotFoundException the file not found exception
 */
public static void computeBias(String file) throws FileNotFoundException{
	long org[] = new long[64];
	long s[][]=new long[4][16];
	long sub[]=new long[64];
	Scanner src=new Scanner(new File(file));
	for(int i=0;i<4;i++){
		for(int j=0;j<16;j++){
			s[i][j]=src.nextInt();
		}
	}	
			
	for(int i=0;i<64;i++){
		org[i]=i;
	}
	for(int i=0;i<64;i++){
		String temp=Long.toBinaryString(org[i]);
		while(temp.length()!=6)temp="0"+temp;
		String temp1= Character.toString(temp.charAt(0))+temp.charAt(5);
		int a=Integer.parseInt(temp1,2);
		temp1=Character.toString(temp.charAt(1))+temp.charAt(2)+temp.charAt(3)+temp.charAt(4);
		int b=Integer.parseInt(temp1,2);
		sub[i]=s[a][b];

	}	

System.out.println(Arrays.toString(sub));
				// Split for X and Y
				String biCombX ="010000";
				String biCombY ="100100";

				int count = 0;
				for (int j = 0; j < org.length; j++) {
					long a = 0;
					long b = 0;
					String x = new String();
					String y = new String();

					for (int q = 0; q < 6; q++) {
						if (biCombX.charAt(q) == '1') {
							long temp = 0;
							String tempS = Long.toBinaryString(org[j]);
							while (tempS.length() != 6)
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
							while (tempS.length() != 6)
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
				double bias=((float)(count-32))/64;
			//	System.out.println(file+": "+bias);
}
	
}
