package kr.hs.dgsw.java.dept1.do0427;

public class Zoo {

//	public void breed(Dog dog) {
//		dog.printSound();
//	}
//	
//	public void breed(Cat cat) {
//		cat.printSound();
//	}
//	
//	public void breed(Horse horse) {
//		horse.printSound();
//	}
//	
	
	public void breed(Animal animal) {
		animal.printSound();
	}
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		Dog dog = new Dog();
		zoo.breed(dog);
		
		Cat cat = new Cat();
		zoo.breed(cat);
		
		Horse horse = new Horse();
		zoo.breed(horse);
	}
}
