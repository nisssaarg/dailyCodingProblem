/*
 * Given an array of integers, find the first missing integer in linear time and constant space. 
 * In other words, find the lowest integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */

import java.util.Scanner;

public class missingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String s=sc.next();
		String[] st=s.split(",");
		int[] arr=new int[st.length];
		int min=99,max=-99;

		int sum=0;

		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st[i]);
			//sum=sum+arr[i];
			max=Math.max(arr[i],max);
			min=Math.min(arr[i],min);
		}

		for(int i=min;i<=max;i++)
			sum+=i;

		for(int i=0;i<arr.length;i++) {
			sum=sum-arr[i];
		}

		System.out.println(sum);

	}
}
