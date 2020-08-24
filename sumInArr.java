/*
 * 
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.In a single pass.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 
 */

// Author:Nisarg Devdhar


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class sumInArr {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		
		int k=sc.nextInt();
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		sc.close();

		System.out.println(result(k,n,arr));
		
	}

	private static boolean result(int k, int n, int[] arr) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<Integer>();
		for(int i:arr) {
			int remaining=k-i;
			if(set.contains(remaining))
				return true;
			
			set.add(i);
		}
		return false;
	}
}
