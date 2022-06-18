package Subject02;

import java.io.*;
import java.util.*;



public class Controller {
    ArrayList<Phone> phone;    // Phone이 있는 ArrayList를 phone이라고 선언
    FileWriter fw;
    Scanner sc;
    FileReader fr;

    public Controller() throws IOException {
        phone = new ArrayList<Phone>();
        // phone 변수에 ArrayList<Phone>객체 생성 해서 대입
        sc = new Scanner(System.in);

    }

    public void input(FileWriter fw) throws IOException {
        if (phone.size() == 0) // ArrayList 변수 phone의 크기가 0이면 실행
        {
//            String opn1 = "이름"+"\t\t"+"전화번호"+"\r\n";
            //문자열 변수 opn1에 위에 문자열 대입
            phone.add(new Phone("이름", "전화번호"));
            //ArrayList 변수 tel의 리스트 추가 Phone 객체를 생성해서 추가
//            fw.write(opn1);
            // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 문자열 쓰기
        }

        System.out.print("이름 : "); //입력
        String name = sc.next(); // String name에 입력 값 대입
        System.out.print("전화번호 : "); //입력
        String number = sc.next(); // String number에 입력 값 대입

        phone.add(new Phone(name, number));
        //ArrayList 변수 tel의 리스트 추가 Phone 객체를 생성해서 추가 Phone은 입력받은 값을 생성자에 추가

        phone.sort((Phone o1, Phone o2) -> {
            return o1.name.compareTo(o2.name);
        });

        String tatal = name + "\t\t" + number + "\r\n";
        // 문자열 tatal 에 입력 받은 문자열을 더해서 대입
        fw.write(tatal);
        // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 tatal문자열 쓰기
        fw.close();
        //FileWriter 끄기
    }

    public void input(FileWriter fw, Phone p) throws IOException {
        if (phone.size() == 0) // ArrayList 변수 tel의 크기가 0이면 실행
        {
            phone.add(new Phone("이름", "전화번호"));
        }
        String total = p.name + "\t\t" + p.phoneNumber + "\r\n";
        fw.write(total);
        fw.close();
    }

    public void search() {
        System.out.print("검색할 이름을 넣어주세요 : ");
        String search = sc.next(); // 문자열 search에 입력 문자열 대입

        boolean check = false; // boolean check 변수를 false로 초기화
        int index = 0; // int index 변수를 -1로 초기화
        //index = -1;
        for (int i = 0; i < phone.size(); i++)
        //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        {
            if (phone.get(i).name.equals(search))
            //ArrayList tel에 i 인덱스에 이름이 search와 같으면 아래 명령어 실행
            {
                index = i; // 변수 index에 i를 대입
                check = true; // 변수 check에 true 대입
            }
        }

        if (check == true)
            // 변수 check가 true 라면 아래 명령어 실행
            System.out.println(phone.get(index).name + "\t" + phone.get(index).phoneNumber);
        else
            System.out.println("검색결과가 없습니다.");
    }

    public void searchNum(){
        System.out.println("검색할 전화번호를 넣어주세요 : ");
        String searchNum = sc.next();

        boolean check = false;
        int index = 0;
        for(int i=0; i<phone.size(); i++){
            if(phone.get(i).phoneNumber.contains(searchNum)){
                index = i;
                check = true;
            }
        }
        if(check==true)
            System.out.println(phone.get(index).name + "\t" + phone.get(index).phoneNumber);
        else
            System.out.println("검색결과가 없습니다.");
    }

    public void delete(FileWriter fw) throws IOException {
        System.out.print("이름입력 : ");
        String search1 = sc.next();

        for (int i = 0; i < phone.size(); i++)
        //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        {
            if (phone.get(i).name.equals(search1))
            //ArrayList phone에 i 인덱스에 이름이 search와 같으면 아래 명령어 실행
            {
                if (phone.get(i).name.equals(search1) == phone.get(i).name.equals(search1)) {
                    System.out.println(phone.get(i).name + "\t\t" + phone.get(i).phoneNumber + "\r\t");
                    System.out.println("중복된 이름이 있습니다.");
                    System.out.print("전화번호를 입력하세요 : ");
                    String search2 = sc.next();
                    for (i = 0; i < phone.size(); i++) {
                        if (phone.get(i).phoneNumber.contains(search2)) {
                            System.out.println("삭제되었습니다.");
                            phone.remove(i);
                        }
                    }
                }
            }
        }

        //파일에 나타냄.
        for (int i = 0; i < phone.size(); i++)
        //int i 변수를 0으로 대입 i는 ArrayList tel의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        {
            //이름 정렬
            phone.sort((Phone o1, Phone o2) -> {
                return o1.name.compareTo(o2.name);
            });
            String tatal1 = phone.get(i).name + "\t\t" + phone.get(i).phoneNumber + "\r\n";
            //문자열 tatal1에 ArrayList tel에 i인덱스 문자열 이름, 전화번호를 더해서 대입
            fw.write(tatal1);
            // FileWrite의 변수 fw를 이용해 write 함수 호출 파일에 tatal1문자열 쓰기
        }
        fw.close();
        //FileWriter 끄기

    }

    public void deleteall(FileWriter fw) throws IOException {
        File file = new File("D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    public void allPrint() throws IOException {
        String filefolder = "D:\\2103박소영\\JAVA수업(산악)\\PhoneNumber.txt";
        phone.clear();
        //ArrayList tel의 내용 클리어해서 tel을 비움
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
//            System.out.println(line1);
            splitLine1 = line1.split("\t\t");
            //문자열 splitLine 배열에 line1을 "\t\t"로 자른 문자열들을 대입
            phone.add(new Phone(splitLine1[0], splitLine1[1]));
            //ArrayList tel 추가할때 Phone 객체를 생성 하고 생성자는 문자열 splitLine1 배열을 대입
        }

        //이름 정렬
        phone.sort((Phone o1, Phone o2) -> {
            return o1.name.compareTo(o2.name);
        });

        System.out.println("이름\t\t전화번호");

        for (int i = 0; i < phone.size(); i++)
        //int i 변수를 0으로 대입 i는 ArrayList phone의 크기보다 작으면 반복 반복 때마다 i는 1씩 증가
        {
            System.out.println(phone.get(i).name + "\t\t" + phone.get(i).phoneNumber);
        }

        deleteall(new FileWriter(filefolder));
        for (Phone p : phone) {
            File file = new File(filefolder);
            if (file.exists())
                input(new FileWriter(filefolder,true), p);
            else
                input(new FileWriter(filefolder,false), p);
        }
    }
}
