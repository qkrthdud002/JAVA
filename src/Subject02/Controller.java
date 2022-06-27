package Subject02;

import java.io.*;
import java.util.*;

public class Controller {
    List<Phone> phones;    // Phone이 있는 List를 phones이라고 선언
    Scanner sc;
    FileReader fr;

    public Controller() throws IOException {
        phones = new ArrayList<>();
        // phones 변수에 ArrayList<Phone>객체 생성 해서 대입
        sc = new Scanner(System.in);

    }

    void input(FileWriter fw) throws IOException {
        if (phones.size() == 0) // ArrayList 변수 phones의 크기가 0이면 실행
        {
            phones.add(new Phone("이름", "전화번호"));
            //ArrayList 변수 tel의 리스트 추가 Phone 객체를 생성해서 추가
        }

        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("전화번호 : ");
        String number = sc.next();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        phones.add(new Phone(name, number));
        //ArrayList 변수 phones의 리스트 추가 Phone 객체를 생성해서 추가 Phone은 입력받은 값을 생성자에 추가

        phones.sort(Comparator.comparing((Phone o) -> o.name));

        String total = name + "\t\t" + number + "\r\n";
        // 문자열 total 에 입력 받은 문자열을 더해서 대입
        fw.write(total);
        // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 total문자열 쓰기
        fw.close();
        //FileWriter 끄기
    }

    void search() {
        System.out.print("검색할 이름을 넣어주세요 : ");
        String search = sc.next(); // 문자열 search에 입력 문자열 대입

        boolean check = false; // boolean check 변수를 false로 초기화
        //int i 변수를 0으로 대입 i는 ArrayList phones의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        System.out.println("이름\t\t\t전화번호");
        for (Phone phone : phones) {
            String name = phone.name;
            String number = phone.phoneNumber;
            // 자바 정규 표현식 matches 사용.
            // . : 임의의 한 문자
            // * : 문자가 0번 이상 발생
            if (name.matches(String.format("(.*)%s(.*)", search))) {
                System.out.println(name + "\t\t" + number);
                check = true;
            }
        }
        if (!check) {
            System.out.println("검색결과가 없습니다.");
        }
    }

    void searchNum(){
        System.out.print("검색할 전화번호를 넣어주세요 : ");
        String searchNum = sc.next();

        boolean check = false;
        System.out.println("이름\t\t\t전화번호");
        for (Phone phone : phones) {
            String name = phone.name;
            String number = phone.phoneNumber;
            if (number.matches(String.format("(.*)%s(.*)", searchNum))) {
                System.out.println(name + "\t\t" + number);
                check = true;
            }
        }
        if(!check)
            System.out.println("검색결과가 없습니다.");
    }

    List<Phone> isOverlap(String name) {
        List<Phone> namePhoneList = new ArrayList<>();
        for (Phone p : phones) {
            String pName = p.name;
            if (pName.equals(name)) {
                namePhoneList.add(p);
            }
        }
        namePhoneList.sort(Comparator.comparing((Phone o) -> o.name));
        return namePhoneList;
    }

    void delete(FileWriter fw) throws IOException {
        System.out.print("이름입력 : ");
        String search1 = sc.next();

        List<Phone> phoneList = isOverlap(search1);
        int phoneSize = phoneList.size();

        if (phoneSize == 0) {
            // 존재하지 않음
            return;
        }

        if (phoneSize > 1) {
            System.out.println("중복된 이름이 있습니다.");
            System.out.println("이름\t\t\t전화번호");
            for (Phone phone : phoneList) {
                System.out.printf("%s \t\t %s%n", phone.name, phone.phoneNumber);
            }

            System.out.print("전화번호를 입력해주세요 : ");
            search1 = sc.next();
            Phone target = phoneList.get(0);
            for (Phone phone : phoneList) {
                if (phone.phoneNumber.equals(search1)) {
                    target = phone;
                }
            }
            phones.remove(target);
        }
        else {
            phones.remove(phoneList.get(0));
        }

        // 가변 문자열 StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        for (Phone phone : phones) {
            //append() 메소드를 사용 -> 기존 문자열을 추가하는 기능
            stringBuilder.append(phone.name)
                    .append("\t\t")
                    .append(phone.phoneNumber)
                    .append("\r\n");
        }
        fw.write(stringBuilder.toString());
        fw.close();
        //FileWriter 끄기
    }

    void allPrint() throws IOException {
        String filefolder = "D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt";
        phones.clear();
        //ArrayList phones의 내용 클리어해서 phones을 비움
        fr = new FileReader(filefolder);
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
            phones.add(new Phone(splitLine1[0], splitLine1[1]));
            //ArrayList phones 추가할때 Phone 객체를 생성 하고 생성자는 문자열 splitLine1 배열을 대입
        }

        //이름 정렬
        phones.sort(Comparator.comparing((Phone o) -> o.name));

        System.out.println("이름\t\t전화번호");

        //int i 변수를 0으로 대입 i는 ArrayList phones의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        for (Phone phone : phones) {
            System.out.println(phone.name + "\t\t" + phone.phoneNumber);
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
}