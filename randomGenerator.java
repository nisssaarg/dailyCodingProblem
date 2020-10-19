/*
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
 *  implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 */
import java.util.Random;

public class randomGenerator {

	public static int rand5() {
		return new Random().nextInt(5)+1;
	}
	
	public static int rand7() {
		int r;
		do {
			r=5*(rand5()-1)+rand5();
		}while(r>7);
		
		return r;
	}
	
	public static void main(String[] args) {
		//System.out.println(rand7());
		test1();
	}

	static int[] count=new int[8];
	
	private static void test1() {
		// TODO Auto-generated method stub

	int n=10000;
		for(int i=0;i<n;i++) {
			int val=rand7();
			count[val]++;
		}
		
		for(int i:count)
			System.out.println(i);
	}
}
