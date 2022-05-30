package kr.hs.dgsw.java.dept21;

public class DogTester {

	public static void main(String[] args) {
		Dog jindo = new Dog();
		Dog chichu = new Dog();
		
		jindo.name = "진돗개";
		jindo.weight = 8.5;
		jindo.color = "베이지색";
		
		chichu.name = "시츄";
		chichu.weight = 3.2;
		chichu.color = "흰색";
		
		jindo.makeSound();
		jindo.eat("뼈다귀");
		jindo.printInformation();
		
		chichu.makeSound();
		chichu.eat("사료");
		chichu.printInformation();
	}
}
