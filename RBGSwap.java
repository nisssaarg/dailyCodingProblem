/*
Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

we represent R with 0, G with 1 ,B with 2
 */
public class RBGSwap {
	public static void main(String[] args) {
		int[] arr= {1,2,0,0,2,0,1};
		arr=swap(arr);
		for(int i:arr) {
			System.out.println(i);
		}
	}

	private static int[] swap(int[] nums) {
		// TODO Auto-generated method stub
		if(nums==null||nums.length<2)
			return null;
		
		int[] count=new int[3];
		for(int i=0;i<nums.length;i++) {
			count[nums[i]]++;
		}
		
		 
	    int j = 0;
	    int k = 0;
	    while(j<=2){
	        if(count[j]!=0){
	            nums[k++]=j;
	            count[j] = count[j]-1;
	        }else{
	            j++;
	        }
	    }
	    
	    return nums;
	}


}
