package testJunit;

public class Calculator {
	private static int results;
	
	public void add(int n){
		results=results+n;
	}
	
	public void substract(int n) {
		results=results-n;
	}
	
	public void multiply(int n) {
		results=results*n;
	}
	
	public void divide(int n) {
		results=results/n;
	}
	
	public void clear() {
		results=0;
	}
	
	public int getResults() {
		return results;
	}

}
