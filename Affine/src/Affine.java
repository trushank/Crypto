/**
Affine.java
@author Trushank
Date: Oct 16, 2013
 */
public class Affine {

    public static void main(String[] args) {
	
	String CipherText="XKPKMSXAPSXUCYPAPUAWQOQXWQPVQAUVSEKXSSEUASLKXWONDSRQMTOSYESFSVPWQYEWKVAPQXWKOYHOGTUHMSSRQGSNSNDKEWQXWONSNDKEWQXWQCKNSHQGKAXKEUMHOAPQXWOVOCNWXGOYSARKHXQGSAPUHWENDSEKVPQXWOCWXWCKHXQGSNSPWSCOYEWKVAPQXYSARKHXUABVHKNDKASEXWMSECSPQNSRKEWKYWQRQYPAPQRKMWQYEURKTMWVHKXWQMTSDUABDSVPKRSEOYHOGKHQPKTSNSPKEURKTMKCWDUXQMOYHOGCSGHFUPSYTKAYPUFAWQRSTEKDTUMSCQXTKDPQLKABSEASEEYNDKEWQNSHYMWCSEWKPQENDKEVPWQCSGKXWQYMSDPUYTKANSHYAUDSFSTXWAUFOVSEHKXWKHQYMSDPUYTKALWDCUSLQDORKAQXSESAPQYXQOYHOGWFWODKDKABOXMSEQLWDCUSNDSGDKCSEKXWKMSCNOTQDSEQGS";
	char a='O';
	char a1='S';
	char b='X';
	char b1='Z';
	int invA=0;
	int A=0;
	int B=0;
	String key=new String();
	
	System.out.println("We have two equations as:\n"+(a-65)+"a+b="+(a1-65)+"\n"+(b-65)+"a+b="+(b1-65));
	
	System.out.println("\nOn solving we get 'a','b' as: ");
	
	int x1=b1-a1;
	int x=b-a;
	for(int i=1;i<27;i++){
		   
	    if(((i*x)%26)==x1){
		int ans=((a1-65)-((a-65)*i));
		while(ans<0)
		    ans+=26;
		B=ans;
		A=i;
		System.out.println(i+","+ans);
	    }
	  
	    
	   
	}
	  System.out.println("\nHence the  Encryption key is: ");
	 for(int i=0;i<26;i++){
		System.out.print((char)(i+65));
	    }
	 System.out.println();
	 for(int i=0;i<26;i++){
	     key+=(char)((((A*i)+B)%26)+65);
		
	    }
	 System.out.println(key+"\n\nHence on reversing we get the following plaintext");
	 for(int i=0;i<CipherText.length();i++){
	     System.out.print((char)((key.indexOf(CipherText.charAt(i)))+65));
	     
	 }
//	invA=A;
//	 
//	 invA%=26 ;
//	    for(int j = 1; j < 26; j++) {
//	        if((invA*j) % 26 == 1) {
//	            invA=j;
//	        break;
//	        }
//	    }
//	
//	System.out.println("\n\n");
//    for(int i=0;i<26;i++){
//	System.out.print((char)((((i-B)*invA)%26)+65));
//    }
	
    }
}



