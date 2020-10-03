/*
 * Given an array of integers where every integer occurs three times except for one integer, which only occurs once, 
 * find and return the non-duplicated integer.
 * 
 * For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
 * Do this in O(N) time and O(1) space.
 */
public class singleDigit {
	public static int getDigit(int[] arr) {
		int one=0,two=0;
		int mask;
		
		for(int i=0;i<arr.length;i++) {
			two=two | (one & arr[i]);
			one = one^arr[i];
			
			mask= ~(one & two);
			one &=mask;
			two &=mask;
		}
		
		return one;
	}
	
	public static void main(String[] args) {
		int[] arr= {3,3,2,3};
		System.out.println(getDigit(arr));
	}
}
