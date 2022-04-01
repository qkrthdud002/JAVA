package kr.hs.dgsw.Ex1;

public class Start {
	public static void main(String[] args) {
		
		//double bmi;
		
		People a = new People();
		People b = new People();
		
		a.name = "김영희";
		a.height = 165;
		a.weight = 55;

		b.name = "김철수";
		b.height = 170;
		b.weight = 90;
		
		a.BMI();
		a.printBmi();
		
		b.BMI();
		b.printBmi();
		
	}
}
