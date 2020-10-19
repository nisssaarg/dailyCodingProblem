/*
 * Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. 
 * If such a subset cannot be made, then return null.
 * Integers can appear more than once in the list. You may assume all numbers in the list are positive.
 * For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, 
 * return [12, 9, 2, 1] since it sums up to 24.
 */

import java.util.ArrayList;
import java.util.List;

public class sumSubset {
		public static List<Integer> sum(int[] arr,int total) {
			int n=arr.length;
			int sum;
			for(int i=0;i<(1<<n);i++) {
				ArrayList<Integer> result=new ArrayList<Integer>();
				sum=0;
				for(int j=0;j<n;j++) {
					 if ((i & (1 << j)) > 0) {
						 sum=sum+arr[j];
						 result.add(arr[j]);
					 }
				}
				 System.out.println("Sum"+sum);
				if(sum==total) {
					return result;
				}
			}
			
			return null;
		}
		
		public static void main(String[] args) {
			int[] s= {12, 1, 61, 5, 9, 2};
			int k=24;
			List<Integer> result= sum(s,k);
			if(result==null) {
				System.out.println("null");
				return;
			}
			
			for(Integer i:result) {
				System.out.print(i+" ");
			}
		}
}
