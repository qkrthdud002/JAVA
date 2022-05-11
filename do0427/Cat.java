package kr.hs.dgsw.java.dept1.do0427;

public class Cat extends Animal { //abstract를 넣어줘도 Cat에 나타난 에러를 없애준다.

	//Cat에 나타난 에러를 삭제시켜줌.
	@Override
	public String makeSound() {
		return "야옹";
	}
	
	@Override
	public String getName() {
		return "고양이";
	}
	
	
}
