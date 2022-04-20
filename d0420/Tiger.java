package kr.hs.dgsw.java.dept1.d0420;

public class Tiger extends Mammal {
	
	public void makeSound() {
		System.out.println("야옹");
	}
	
	@Override
	public void move() {
		System.out.println("펄쩍 뛰어 오릅니다.");
	}
	
	@Override 
	public void birth() {
		System.out.println("호랑이가 무서운 새끼를 낳습니다.");
	}
	
	public static void main(String[] args) {
		
		Tiger tiger = new Tiger();
		tiger.move();
		tiger.birth();
		tiger.makeSound();
		
		Mammal tiger2 = new Tiger();
		tiger2.move();
		tiger2.birth();
		//tiger2.makeSound(); //Mammal로 해서 오류뜬다.
		
		//String abc = new Tiger();
		
	}

}
