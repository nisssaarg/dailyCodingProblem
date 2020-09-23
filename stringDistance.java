/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. 
For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”,
 substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them
 */
public class stringDistance {

		// Utility function to find minimum of three numbers
		public static int minimum(int a, int b, int c)
		{
			return Integer.min(a, Integer.min(b, c));
		}

		// Function to find Levenshtein Distance between String X and Y
		// m and n are the number of characters in X and Y respectively
		public static int dist(String X, int m, String Y, int n)
		{
			// base case: empty strings (case 1)
			if (m == 0) {
				return n;
			}

			if (n == 0) {
				return m;
			}

			// if last characters of the strings match (case 2)
			int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0: 1;

			return minimum(dist(X, m - 1, Y, n) + 1,  // deletion (case 3a))
					dist(X, m, Y, n - 1) + 1,		 // insertion (case 3b))
					dist(X, m - 1, Y, n - 1) + cost); // substitution (case 2 & 3c)
		}

		public static void main(String[] args)
		{
			String X = "kitten", Y = "sitting";

			System.out.print(dist(X, X.length(), Y, Y.length()));
		}
}
