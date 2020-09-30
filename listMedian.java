/*
Compute the running median of a sequence of numbers. 
That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
 */

import java.util.ArrayList;

public class listMedian {

	public static ArrayList<Integer> median(int[] nums,int n){
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int m=medianHelper(nums,i);
			result.add(m);
		}
		return result;
	}
	
	private static int medianHelper(int[] nums, int i) {
		// TODO Auto-generated method stub
		if(i==0)
			return nums[i];
		else if(i%2==0)
			return nums[i/2];
		else {
			int mid=i/2;
			int med=(nums[mid]+nums[mid+1])/2;
			return med;
		}
		//return 0;
	}

	public static void main(String[] args) {
		int[] arr= {2,1,5,7,2,0,5};
		ArrayList<Integer> result= median(arr,arr.length-1);
		for(int i:result)
			System.out.println(i);
	}
}
