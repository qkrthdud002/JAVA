package kr.hs.dgsw.dept1.do0330;

public class Dog {

	//한번 값이 생성되면 바꿀수없다.
	private final String name;
	
	private int age;
	
	public Dog(String name) {
		//this는 항상 젤 위에 있어야 함.
		this(name, 0);
		//System.out.println("adfasf");
	}
	
	public Dog(String name, int age) {
	//리턴타입이 있으면 생성자 역할을 하지 못한다.
	//이름이 같아야 된다.
		this.name = name;
		this.age = age;
		System.out.println("생성자가 호출되었습니다.");
	}
	
	public void print() {
		System.out.printf("%s는 나이가 %d살입니다.\n", this.name, this.age);
	}
	
//	public String getName() {
//		return this.name;
//	}
//	
//	
	
	public static void main(String[] args) {
		
		//생성자가 하나라도 있으면 사라진다.
		Dog happy = new Dog("해피", 5);
		happy.print();
		//happy.getName();
		
		Dog puppy = new Dog("퍼피");
		
		System.out.println("Count of args : " + args.length);
		for(int i=0; i<args.length; i++) {
			System.out.printf("%d - %s\n", i, args[i]);
		}
		
		
	}
}
