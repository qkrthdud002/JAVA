package kr.hs.dgsw.dept1.do0330;

public class Cat {

	private String color;
	private final String name;
	private double weight;
	
	public Cat(String color) {
		this(color, "bbb", 11);
	}
	
	public Cat(String color, String name, double weight) {
		this.color = color;
		this.name = name;
		this.weight = weight;
		
		System.out.println("생성자가 호출되었습니다.");
	}
	
	public void print() {
		System.out.printf("색상과 이름, 몸무게는 각각 %s, %s, %lf이다.", this.color, this.name, this.weight);
	}
	
//	public String getName() {
//		return this.name;
//	}
	
	public static void main(String[] args) {
		Cat abc = new Cat("blue", "aaaa", 13);
		Cat cde = new Cat("black");
		abc.print();
	//	abc.getName();
	}
	
}
