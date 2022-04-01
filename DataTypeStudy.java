package kr.hs.dgsw.java.dept1.d0323;

public class DataTypeStudy {

	public void studyIntegerType() {
		int intValue = 2000000000;
		byte byteValue = 127;
		short shortValue = -3000;
		long longValue = 3000000000L; //뒤에 L을 붙여야 함.
		
		Integer integer = 3; //참조 데이터 타입
	}
	
	public void studyRealNumberType() {
		float piFloat = 3.1415926123456789F; //뒤에 F를 붙여야 함.
		double piDouble = 3.1415926123456789;
		
		System.out.println(piFloat);
		System.out.println(piDouble);
	}
	
	public void studyBoolean() {
		
		System.out.println((4>2));
		
		boolean flag = true;
		boolean win = false;
		
		if(4 > 2) {
			// do something
		}
	}
	
	public void studyChar() {
		char ch1 = 'A'; //하나의 문자 A
		String str = ""; //문자열 A, 아무 문자 없어도 사용 가능
		int ch2 = 65;
		
		System.out.println((int)ch1); //char타입과 int형은 서로 바꿀 수 있다.
		System.out.println((char)ch2);
		
		char h1 = '가';
		System.out.printf("%d - %c\n", (int)h1, h1);
		System.out.printf("%d - %c\n", (int)44033, (char)44033);
		System.out.printf("%d - %c\n", (int)44034, (char)44034);
		System.out.printf("%d - %c\n", (int)44035, (char)44035);

		
		int countOfHangeul = '힣' - '가' +1;
		System.out.println("한글에 부여된 코드의 개수 : "+countOfHangeul);
		
		
//		for(int i=30000; i<=40000; i++) {
//			char  ch = (char)i;
//			
//			System.out.printf("%03d %02X - %c\n", i, i, ch);
//		}
//		
	}
	
	public static void main(String[] args) {
		DataTypeStudy study = new DataTypeStudy();
		study.studyBoolean();
	}
	
}
