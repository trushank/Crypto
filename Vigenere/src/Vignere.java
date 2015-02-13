import java.util.ArrayList;

/**
 * Vignere.java
 * 
 * @author Trushank Date: Oct 15, 2013
 */
public class Vignere {

    public static void main(String args[]) {
	String cipherText = "FCPJMDJUEFBPMLIRQYBTIGTFMRDWATMMAAVLVXUJWPMAUWDPTCAHZTNVRSCDJEAVMASFDMKNJFNVMMJFDAMDFCDWJCBJIDMYFCEKBLEFDWUTORSYMCBZSKCOFJTWGASFCDIXPHUWMYVEFMBFSFMMGASFXAUZFCPWBCPCEGVZTVRSUZUZVGLPVEAYCPSIAYZLDZAKIWPJCGUMVJTAJWFJRWVZWRBDMDFEOLZZBJPWKEPCUDIQJIMGCYBEOJULRLEDMRBCIRIWPJCMTEJMOKBCBESYMYJTOKGCFXUDIPMJEUBZSUETQZUVCFWWPXISYFFZNUTFZVLSQYWVSLQRBTIGVOFTEDCWBJMSLCFKEEIDRLEZIYEVSSBLEFDWJLUVSSKLMFRSLZTVNLZPBXRAKFMKOJMDBDBAMYURLAAEBJCAMYUZFAKZTPGJCAPJRWTTHZOKWDFJTSUZTUEEWDUIAFLZBCMMVOPHUWMDQFSAJWFTRWICVECGUMVJTAJWFUEMVLGLEFBPSVNGDLCCEUWXPVLYQCBJODGPMEATWQPIRSRPSFAKMRVIOWTASVSALPOKEVCCBETWTLDVRWUZOZAVMLQVRLCCBUEDIAMRNLIDPPMAVLTVNDINJLDSLOFTAKATBHUWXCPUUUQCBDIDTZOVSVMWJKRGAOFSIGLTFJEDXZSRNG";
	ArrayList<Integer> list = new ArrayList<>();
	ArrayList<Integer> factors = new ArrayList<Integer>();
System.out.println("First we find the repeating set of three characters");
	// Finding repetitions of three characters
	for (int i = 0; i < cipherText.length(); i++) {
	    try {
		String mask = cipherText.substring(i, i + 3);
		for (int j = i + 3; j < cipherText.length(); j++) {
		    try {
			if (mask.equals(cipherText.substring(j, j + 3))) {
			    // Saving the distance of that repetition
			    System.out.print(mask+" ");
			    list.add(j - i);
			    break;
			}
		    } catch (Exception e) {
		    }
		}
	    } catch (Exception e) {
	    }
	}
	System.out.println("\n\nNow we find the distance between repeating three character sets\n");
	System.out.println("Distance between duplicate chars: Factors (of current distance)");
	for (int i = 0; i < list.size(); i++) {
	    int current = list.get(i);
	    System.out.print(current + ": ");
	    int fact = 2;
	    while (fact <= current) {
		if (current % fact == 0) {
		    System.out.print(fact + " ");
		    factors.add(fact);
		}
		fact++;
	    }
	    System.out.println();
	}
	
	int maxFactor = 0;
	int maxOccurance = 0;
	for (int i = 0; i < factors.size(); i++) {
	    int curr = factors.get(i);
	    if(curr<=3)continue;
	    int currCount = 0;
	    for (int j = i; j < factors.size(); j++) {
		if (curr == factors.get(j)) {
		    currCount++;
		}
	    }
	    if (currCount > maxOccurance) {
		maxFactor = curr;
		maxOccurance = currCount;
	    }
	}
	System.out.println("Most Common Factor (Length of Key) " + maxFactor+"\n\nSplliting the ciphertext based on key length:");
	String[] y=new String[maxFactor];
	for(int i=0;i<y.length;i++){
	    y[i]=new String();
	}
	for(int i=0;i<cipherText.length();i++){
	    y[i%maxFactor]+=cipherText.charAt(i);
	}
	for(int i=0;i<y.length;i++){
	   System.out.println("Y"+i+": "+y[i]);
	}
	
	System.out.println("\nAssuming most frequent character as 'e'");
	String freqChars=new String();
	for(int i=0;i<y.length;i++){
	    char freq='-';
	    int count=0;
	    for(int j=0;j<y[i].length();j++){
		    char tfreq=y[i].charAt(j);
		    int tcount=0;
		for(int x=j;x<y[i].length();x++){
		   if(y[i].charAt(x)==tfreq)
		    tcount++;
		}
		if(tcount>count){
		    count=tcount;
		    freq=tfreq;
		}
	    }
	    freqChars+=freq;
	}
	System.out.println("Possible 'e's in Cipher Text are "+freqChars);
	System.out.println("\nNow if we shift the alphabet by 4 (e=5) we should be able to find the key");
	
	for(int i=0;i<26;i++){
	    System.out.print((char)(i+65));
	}
	System.out.println();
	for(int i=0;i<26;i++){
	    System.out.print((char)(((22+i)%26)+65));
	}
	String key=new String();
	System.out.println("\n\nHence the Key can be (suggesion): ");
	for(int i=0;i<freqChars.length();i++){
	   key+=((char)(((freqChars.charAt(i)-65-4)%26)+65));
	}
	 System.out.println(key);
	 
	 //Actually key seems to be TSUNAMI (not TSUCAMI). Hence adding modification
	// key=key.replace('C', 'N');
	 
	 //Decrypting Cipher Text
	 System.out.println("\nDecrypting CipherText with key: "+key);
	 
	 for(int i=0;i<cipherText.length();i++){
	     int keyChar=key.charAt(i%key.length())-65;
	     int cipherChar=cipherText.charAt(i)-65;
	     int diff=cipherChar-keyChar;
	     if(diff<0){
		 diff=26+diff;
	     }
	     
//	     diff=diff%26;
	     diff+=65;
	     System.out.print((char)diff);
	 }
    }
}
