/*
Run-length encoding is a fast and simple method of encoding strings. 
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding.
You can assume the string to be encoded have no digits and consists solely of alphabetic characters. 
You can assume the string to be decoded is valid.
 */

//Author:Nisarg Devdhar
public class encodeString {

	public static String encode(String s) {
		char[] ch=s.toCharArray();
		int lastIndex=1;
		//int k=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<ch.length-1;i++) {
			if(ch[i]==ch[i+1]) {
				lastIndex++;
			}
			else {
				sb.append(lastIndex);
				sb.append(ch[i]);
				lastIndex=1;
			}
		}
		sb.append(lastIndex);
		sb.append(ch[ch.length-1]);
		
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(encode("AAAABBBCCDAA"));
		System.out.println(decode("4A3B2C1D2A"));
	}
	private static String decode(String s) {
		// TODO Auto-generated method stub
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i+=2) {
			char ch=s.charAt(i);
			int n=Integer.parseInt(String.valueOf(ch));
			for(int j=0;j<n;j++)
				sb.append(s.charAt(i+1));
		}
		
		return sb.toString();
	}

}
