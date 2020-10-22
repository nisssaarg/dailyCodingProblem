/*
 * Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
 * For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, 
 * since we would take elements 42, 14, -5, and 86.
 * 
 * Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
 * Do this in O(N) time.
 * 
 */
public class sumContiguos {
	public static int maxSubArray(int[] nums) {
	    int result = nums[0];
	    int[] sum =  new int[nums.length];
	    sum[0] = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
	        result = Math.max(result, sum[i]);
	    }
	 
	    return result;
	}
	
	public static void main(String... args) {
		int[] arr= {34, -50, 42, 14, -5, 86};
		System.out.print(maxSubArray(arr));
	}
}
