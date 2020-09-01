import java.util.Scanner;

public class maxNonAdjacentSum {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String s=sc.next();
		String[] ch=s.split(",");
		int[] arr= new int[ch.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(ch[i]);
		
		sc.close();
		int sum=findSum(arr);
		System.out.println(sum);
	}

	private static int findSum(int[] arr) {
		// TODO Auto-generated method stub
		int sum=0;
		int second=0;
		int first=0;
		
		for(int i=arr.length-1;i>=0;i--) {
			sum =Math.max(arr[i]+second ,first);
			second=first;
			first=sum;
			System.out.println("Sum "+sum+" first "+first+" Second "+second);
		}
		return sum;
	}
}
