

/*
 Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
 */

//Author: Nisarg Devdhar

import java.util.LinkedList;
import java.util.Scanner;

public class maxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Array=");
		String s=sc.next();
		String[] st=s.split(",");
		int[] arr=new int[st.length];
		for(int i=0;i<st.length;i++) {
			arr[i]=Integer.parseInt(st[i]);
		}
		
		int k=sc.nextInt();
		//ArrayList<Integer> array=new ArrayList<Integer>();
		sc.close();
		
		int[] result=maxSlidingWindow(arr,k);
		
		for(int i:result)
			System.out.print(i+",");
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums==null||nums.length==0)
	        return new int[0];
	 
	    int[] result = new int[nums.length-k+1];
	 
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	 
	        deque.offer(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}

}
