/*
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once.
 * You must buy before you can sell it.
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5, 
 * since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class stockCalculation {
	
	public static int calculate(int[] arr) {
		int max=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int profit=arr[j]-arr[i];
				if(profit>max)
					max=profit;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr= {9, 11, 8, 5, 7, 10};
		System.out.println(calculate(arr));
	}
}
