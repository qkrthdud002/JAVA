package kr.hs.dgsw.java.dept1.do0427;

public abstract class Animal {
	
	public abstract String getName();

	public abstract String makeSound();

	public void printSound() {
		System.out.println(getName() + "이(가)" + makeSound() + " 노래합니다.");
	}
	
	public static void main(String[] args) {
		Animal animal = new Dog(); //추상 클래스일 때, Animal을 하면 에러. 상속받은 Dog는 에러가 나지 않는다.
		animal.printSound();
	}
	
}
