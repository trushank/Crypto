
public class QProgram {

	public static void main(String[] args) {
		double deno=365;
		double ans=1;
		System.out.println("Q  Theorem 4.4 \"E\"\t\tEstimated \"E\"\t\t\tDifference");
		for(double j=15;j<=30;j++){
			double e=1-Math.exp((-j*(j-1)/(2*deno)));
			ans=1;
		for(double i=364;i>deno-j;i--){
			ans=ans*(i/deno);
		}
		ans=1-ans;
		System.out.println((int)j+" "+ans+"\t\t"+e+"\t\t"+(ans-e));
	}
	
	}
	
//public static void main( String args[]){
//		
//		double m = 365;
//		double q = 15;
//		double res = 1;
//	
//	for(double i =m-1; i >= m-q+1 ; i--){
//		
//		res *=((m-i)/m);
//	}
//	
//	
//	System.out.print(res);
//	}


}
