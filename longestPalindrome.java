/*
 * Given a string, find the longest palindromic contiguous substring. 
 * If there are more than one with the maximum length, return any one.
 * For example, the longest palindromic substring of "aabcdcb" is "bcdcb". 
 * The longest palindromic substring of "bananas" is "anana".
 */


public class longestPalindrome {
	public static String longestPalSub(String str) {
		int max=1;
		int start=0;
		int len=str.length();
		
		int low = 0,high = 0;
		
		for(int i=0;i<len;i++) {
			low=i-1;
			high=i;
			
			while(low>=0 && high <len && str.charAt(low)==str.charAt(high)) {
				if(high-low+1>max) {
					start=low;
					max=high-low+1;
				}
				--low;
				++high;
			}
			
			low=i-1;
			high=i+1;
			
			while(low>=0 && high <len && str.charAt(low)==str.charAt(high)) {
				if(high-low+1>max) {
					start=low;
					max=high-low+1;
				}
				--low;
				++high;
			}
		}
		
		return str.substring(start,start+max);
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalSub("bananas"));
	}
}
