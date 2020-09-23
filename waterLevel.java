/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height.
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */
public class waterLevel {
	public static int trap(int[] height) {
	    int result = 0;
	 
	    if(height==null || height.length<=2)
	        return result;
	 
	    int left[] = new int[height.length];
	    int right[]= new int[height.length];
	 
	    //scan from left to right
	    int max = height[0];
	    left[0] = height[0];
	    for(int i=1; i<height.length; i++){
	        if(height[i]<max){
	            left[i]=max;
	        }else{
	            left[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //scan from right to left
	    max = height[height.length-1];
	    right[height.length-1]=height[height.length-1];
	    for(int i=height.length-2; i>=0; i--){
	        if(height[i]<max){
	            right[i]=max;
	        }else{
	            right[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //calculate totoal
	    for(int i=0; i<height.length; i++){
	        result+= Math.min(left[i],right[i])-height[i];
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
		int[] arr= {3, 0, 1, 3, 0, 5};
		System.out.println(trap(arr));
	}
}
