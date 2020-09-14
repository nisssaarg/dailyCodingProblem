/*
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. 
If there is more than one possible reconstruction, return any of them.
If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", 
you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", 
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */

// Author: Nisarg Devdhar
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class stringReconstruction {

	public static void main(String[] args) {
		
	}
	
	public static List<String> wordBreak(String s,Set<String> dict){
		List<String> dp=new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
	
			for(String word:dict) {
				int len=word.length();
				int end=i+len;
				
				if(end>s.length())
					continue;
				
				if(s.substring(i, end).equals(word)) {
					dp.add((String) s.subSequence(i, end));
				}
			}
		}
		
		return dp;
	}
}
