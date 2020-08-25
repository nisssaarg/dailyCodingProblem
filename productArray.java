/*
 * Given an array of integers, return a new array such that each element at index i 
 * of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], 
 * the expected output would be [120, 60, 40, 30, 24]. 
 * If our input was [3, 2, 1], 
 * the expected output would be [2, 3, 6].
 */
import java.util.Scanner;

public class productArray {

	int[] arr=null;
	int[] result=null;
	
	public static void main(String[] args) {
		productArray pa=new productArray();
		pa.maniArray();
		for(int i=0;i<pa.result.length;i++)
			System.out.print(pa.result[i]+" ");
	}
	
	public productArray() {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String s=sc.next();
		String[] number=s.split(",");
		arr=new int[number.length];
		result=new int[number.length];
		for(int i=0;i<number.length;i++)
			arr[i]=(Integer.parseInt(number[i]));
		sc.close();
	}
	
	public void maniArray() {
		for(int i=0;i<arr.length;i++) {
			int product=1;
			for(int j=0;j<arr.length;j++) {
				if(i==j)
					continue;
				product=product*arr[j];
			}
			result[i]=product;
		}
	}
}
