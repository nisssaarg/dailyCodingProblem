/*
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 */
public class pairReturn {

	static class Pair<T>{
		public T a;
		public T b;
		 
		public Pair(T a,T b) {
			this.a=a;
			this.b=b;
		}
	}
	
	public static void main(String[] args) {
		Pair<Integer> pair=new Pair<Integer>(8,10);
		car(pair);
		cons(pair);
	}


	private static void cons(Pair<Integer> pair) {
		// TODO Auto-generated method stub
		System.out.println("cons:"+ pair.b);
	}


	private static void car(Pair<Integer> pair) {
		// TODO Auto-generated method stub
		System.out.println("Car:"+ pair.a);
	}
}
