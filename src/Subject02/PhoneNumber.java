package Subject02;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) throws IOException {
        ArrayList<Phone> phone = new ArrayList<Phone>();
        //Phone의 데이터를 가지는 ArrayList의 변수를 phones이라고 만들고
        //Phone의 데이터를 가지는 ArrayList의 객체를 만들어서 변수 phones에 대입
        Controller controller = new Controller();
        //Controller 라는 클래스 변수 이름을 c로 하고 Controller 객체를 생성해서 대입
        File file = new File("D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt");
        FileReader fr;
        if (file.exists()) {
            phone.clear();
            //ArrayList phones의 내용 클리어해서 tel을 비움
            fr = new FileReader(file);
            //FileReader fr에 FileReader 객체를 생성 생성자 인자에는 파일경로를 문저열로 넣어서 객체 생성
            BufferedReader reader1 = new BufferedReader(fr);
            // BufferReader reader1에 BufferedReader 객체를 생성 생성자 인자에는 FileReader을 넣어서 객체 생성
            String line1;
            //문자열 line1 생성
            String[] splitLine1 = null;
            //문자열 배열 splitLine을 생성 하고 null 값 대입

            while ((line1 = reader1.readLine()) != null)
            //BufferReader reader1을 이용해 한줄을 읽어 와서 문자열 line1에 대입하고 line1이 널이 아니면 반복
            {
                splitLine1 = line1.split("\t\t");
                //문자열 splitLine 배열에 line1을 "\t\t"로 자른 문자열들을 대입
                phone.add(new Phone(splitLine1[0], splitLine1[1]));
                //ArrayList phones 추가할때 Phone 객체를 생성 하고 생성자는 문자열 splitLine1 배열을 대입
            }
        }

        while (true) {
            Scanner sc = new Scanner(System.in);
            FileWriter fw; //FileWriter의 fw라는 변수 선언
            System.out.print("| 1.입력 | 2.츌력 | 3.검색(이름) | 4.검색(전화번호) | 5.삭제 | 6.종료 |");
            System.out.println();
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            System.out.print("숫자를 선택하세요 : ");
            int num = sc.nextInt();
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            if (controller.phones.size() == 0)
                //Controller의 변수 controller의 객체변서 tel의 사이즈가 0 이면 실행
                fw = new FileWriter("D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt", false);
                // fw 변수에 FileWriter 객체를 생성해서 대입
                // 객체 생성시 파일 경로명 문자열 생성자 인자에 넣어서 객체 생성 대입
                //덮어쓰기
            else
                fw = new FileWriter("D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt", true);
            //fw 변수에 FileWriter 객체를 생성해서 대입
            // 객체 생성시 파일 경로명 문자열 생성자 인자에 넣어서 객체 생성 대입
            switch (num) {
                case 1:
                    controller.input(fw);
                    // Controller의 변수 controller의 input 함수에 FileWriter 객체 fw를 인자로 넣어서 호출
                    break;
                case 2:
                    controller.allPrint();
                    break;
                case 3:
                    controller.search();
                    break;
                case 4:
                    controller.searchNum();
                    break;
                case 5:
                    FileWriter fw1 = new FileWriter("D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt", false);
                    //FileWriter의 변수명 fw1로 선언 후 FileWriter 객체 생성
                    //객체 생성시 파일 경로명을 문자열로 인자로 전달해서 객체 생성
                    controller.delete(fw1);
                    //Controller의 변수 controller의 deleter 함수에 FileWriter 객체 fw1를 인자로 넣어서 호출
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            if (num == 6)
                break;
        }
    }
}
