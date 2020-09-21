/*
 Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k.
Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly Write an algorithm to justify text.
 Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.
 */

//Author: Nisarg Devdhar

import java.util.ArrayList;
import java.util.List;

public class justifyText {
	
	public static void main(String[] args) {
		String[] arr= {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		int n=16;
		List<String> result=fullJustify(arr,n);
		for(String i:result)
			System.out.println(i);
	}
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
	    List<String> result = new ArrayList<String>();
	 
	    if(words==null || words.length==0){
	        return result;
	    }
	 
	 
	    int count=0;
	    int last=0;
	    ArrayList<String> list = new ArrayList<String>();
	    for(int i=0; i<words.length; i++){
	        count = count + words[i].length();
	 
	        if(count+i-last>maxWidth){
	            int wordsLen = count-words[i].length();
	            int spaceLen = maxWidth-wordsLen;
	            int eachLen = 1;
	            int extraLen = 0;
	 
	            if(i-last-1>0){
	                eachLen = spaceLen/(i-last-1);
	                extraLen = spaceLen%(i-last-1);
	            }
	 
	            StringBuilder sb = new StringBuilder();
	 
	            for(int k=last; k<i-1; k++){
	                sb.append(words[k]);
	 
	                int ce = 0;
	                while(ce<eachLen){
	                    sb.append(" ");
	                    ce++;
	                }
	 
	                if(extraLen>0){
	                    sb.append(" ");
	                    extraLen--;
	                }
	            }
	 
	            sb.append(words[i-1]);//last words in the line
	            //if only one word in this line, need to fill left with space
	            while(sb.length()<maxWidth){
	                sb.append(" ");
	            }
	 
	            result.add(sb.toString());
	 
	            last = i;
	            count=words[i].length();
	        }
	    }
	 
	    int lastLen = 0;
	    StringBuilder sb = new StringBuilder();
	 
	    for(int i=last; i<words.length-1; i++){
	        count = count+words[i].length();
	        sb.append(words[i]+" ");
	    }
	 
	    sb.append(words[words.length-1]);
	    int d=0;
	    while(sb.length()<maxWidth){
	        sb.append(" ");
	    }
	    result.add(sb.toString());
	 
	    return result;
	}
}
