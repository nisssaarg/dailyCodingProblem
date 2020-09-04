/*
 * Implement an autocomplete system. 
 * That is, given a query string s and a set of all possible query strings, 
 * return all strings in the set that have s as a prefix.
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class autoComplete {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println();
		String prefix=sc.next();
		String temp=sc.next();
		String[] arr=temp.split(",");
		
		sc.close();
		
		Complete(arr,prefix);
	}

	private static void Complete(String[] arr, String prefix) {
		// TODO Auto-generated method stub
		List<String> result=new ArrayList<String>();
		int l=prefix.length();
		for(String s:arr) {
			if(prefix.equals(s.substring(0,l)))
				result.add(s);
		}
		
		for(String s:result)
			System.out.println(s);
	}
}
