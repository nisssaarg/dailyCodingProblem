/*
 * Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */

import java.util.Random;

public class randomPicker {
	
	static int res;
	static int count=0;
	public static void main(String[] args) {
		randomPicker rd=new randomPicker();
		int[] num= {1,2,3,4,5,6};
		for(int i=0;i<num.length;i++) {
			System.out.println(rd.randompick(num[i]));
		}
		
	}
	private static int randompick(int x) {
		// TODO Auto-generated method stub
		count++;
		if(count==1)
			res=x;
		else {
			Random r=new Random();
			int i=r.nextInt();
			
			if(i==count-1)
				res=x;
		}
		return res;
	}
}
