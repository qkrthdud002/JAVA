package kr.hs.dgsw.java.dept21;

public class Dog {

	String color;
	
	double weight;
	
	String name;
	
	public void makeSound() {
		System.out.println("멍멍");
	}
	
	public void eat(String food) {
		//System.out.println(name + "이(가) "+ food + "을 먹는다.");
		
		System.out.printf("%s이(가) %s을 먹는다.\n", name, food);
	}
	
	public void printInformation() {
//		System.out.println("이름 : " + name + " 몸무게 : " + weight + " 색깔 : " + color);
		
		System.out.printf("이름 : %s 몸무게 : %.1f 색깔 : %s\n", name, weight, color);
	}
	
	
}
