/*
 * The area of a circle is defined as πr^2.
 *  Estimate π to 3 decimal places using a Monte Carlo method.
 * Hint: The basic equation of a circle is x2 + y2 = r2.
 */
import java.util.Scanner;

public class monteCarloRadius {
	public static void main(String[] args) {
	    Scanner key=new Scanner(System.in);
	    System.out.print("n = ");
	    int n=key.nextInt();
	    double x,y;
	    int k=0;
	    for(int i=1; i<=n; i++){
	      x=Math.random();
	      y=Math.random();
	      if(x*x+y*y<=1) k++;
	    }
	    double p=4.*k/n;
	    System.out.println(p);
	  }  
}
