package kr.hs.dgsw.java.dept1.d0420;

public class Reptiles extends Animal {

	@Override
	public void birth() {
		System.out.println("어미 뱃속에서 새끼를 키워서 놓습니다.");
	}
	
	public static void main(String[] args) {
		
		Reptiles reptiles = new Reptiles();
		reptiles.birth();
	}
	
	
}
