/*
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 * 
 */
import java.util.Scanner;

public class Decode {	
	public static void main(String[] args) {
		Decode d=new Decode();
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String dat=sc.next();
		char[] ch=dat.toCharArray();
		
		int n=ch.length;
		 System.out.println("Count is"+ Decoding(ch, n));
		sc.close();
	}

	private static int Decoding(char[] digits, int n) {
		// TODO Auto-generated method stub
		if (n == 0 || n == 1) 
			return 1; 
		  
		if (digits[0]==0)    
			return 0; 

		int count = 0;  
		
		if (digits[n - 1] > '0') 
			count = Decoding(digits, n - 1); 
		  
		if (digits[n - 2] == '1'||(digits[n - 2] == '2' && digits[n - 1] < '7')) 
		    count +=Decoding(digits, n - 2); 
		  
		    return count; 
	}

}
