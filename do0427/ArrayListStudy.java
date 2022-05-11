package kr.hs.dgsw.java.dept1.do0427;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStudy {

	public void studyArrayList() {
		String[] array = new String[5];
		List<String> list = new ArrayList<String>();
		
		array[0] = "Korea";
		array[1] = "Germany";
		
		// 리스트에 값을 추가하기
		list.add("Korea");
		list.add("Germany");
		list.add("China");
		
		// 값을 읽어오기
		String value = array[0];
		value = array[1];
		
		value = list.get(0);
		value = list.get(1);
		
		// 크기
		int sizeOfArray = array.length;
		int sizeOfList = list.size();
		
		// 특정한 위치에 넣기
		list.add(1, "England");
		
		System.out.println("After adding : " + list.size() + " " + list.get(2));
		
		
		// 삭제하기
		array[1] = null;
		
		list.remove(1);
	}
	
	public static void main(String[] args) {
		ArrayListStudy study = new ArrayListStudy();
		study.studyArrayList();
	}
	
}
