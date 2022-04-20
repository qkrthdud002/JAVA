package kr.hs.dgsw.java.dept1.d0323;

public class test_0323 {

	public void Test() {
		int a=11, b=3;
		
		System.out.println("a + b = " + (a+b));
		System.out.println("a * b = " + (a*b));
		System.out.println("a - b = " + (a-b));
		System.out.printf("a / b = %f", ((double)a/(double)b));
	}
	
	public static void main(String[] args) {
		test_0323 test = new test_0323();
		test.Test();
	}
}
