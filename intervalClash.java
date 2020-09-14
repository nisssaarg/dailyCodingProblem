/*
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should retu
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class intervalClash {
	
	public static void main(String[] args) {
		int[][] arr= {{30,75},{0,50},{60,150}};
		int n=minClassRooms(arr);
		System.out.println(n);
	}

	public static int minClassRooms(int[][] intervals) {
	    Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
	 
	    PriorityQueue<Integer> heap = new PriorityQueue<>();
	    int count = 0;
	    for (int[] itv : intervals) {
	        if (heap.isEmpty()) {
	            count++;
	            heap.offer(itv[1]);
	        } else {
	            if (itv[0] >= heap.peek()) {
	                heap.poll();
	            } else {
	                count++;
	            }
	 
	            heap.offer(itv[1]);
	        }
	    }
	 
	    return count;
	}
}
