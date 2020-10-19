/*
 *  We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
 *  Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
 *  You may assume each element in the array is distinct.
 *  For example, a sorted list has zero inversions.
 *  The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). 
 *  The array [5, 4, 3, 2, 1]has ten inversions: every distinct pair forms an inversion.
 */
import java.util.Arrays; 

public class sortCount { 


	private static int mergeAndCount(int[] arr, int l, int m, int r) 
	{ 

		// Left subarray 
		int[] left = Arrays.copyOfRange(arr, l, m + 1); 

		// Right subarray 
		int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 

		int i = 0, j = 0, k = l, swaps = 0; 

		while (i < left.length && j < right.length) { 
			if (left[i] <= right[j]) 
				arr[k++] = left[i++]; 
			else { 
				arr[k++] = right[j++]; 
				swaps += (m + 1) - (l + i); 
			} 
		} 
		return swaps; 
	} 


	private static int mergeSortAndCount(int[] arr, int l, int r) 
	{  
		int count = 0; 

		if (l < r) { 
			int m = (l + r) / 2; 


			// Left subarray count 
			count += mergeSortAndCount(arr, l, m); 

			// Right subarray count 
			count += mergeSortAndCount(arr, m + 1, r); 

			// Merge count 
			count += mergeAndCount(arr, l, m, r); 
		} 

		return count; 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int[] arr = { 1, 20, 6, 4, 5 }; 

		System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
	} 
} 

