/*
 * The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
 */
import java.util.ArrayList;

public class subsetCreator {
	public static void main(String[] args) {
		ArrayList<Integer> input=new ArrayList<Integer>();
		for(int i=1;i<4;i++)
			input.add(i);
		
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		
		int set_size=(int)Math.pow(2, 3);
		for(int i=0;i<set_size;i++) {
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0;j<input.size();j++) {
				if((i & (1<<j))>0)
					temp.add(input.get(j));
			}
			
			result.add(temp);
		}
		
		for(ArrayList<Integer> i:result) {
			System.out.print("{");
			for(Integer j:i) {
				System.out.print(j+" ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
}
