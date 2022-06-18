package networksub;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ClientMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // TODO: 2022-06-08 로그인 성공하면 break 가 걸려서 while 문을 통과하지만
        // 위에 선언되어있던 while 문에 의헤 다시 로그인을 진행하도록 됨

        Socket socket = null; //서버와 통신하기 위한 소켓
        BufferedReader inputStream = null; //서버로부터 데이터를 읽어들이기 위한 입력 스트림
        BufferedReader keyboardInput = null; //키보드로부터 읽어들이기 위한 입력 스트림
        BufferedOutputStream outputStream = null;
        PrintWriter outGoing = null;
        InetAddress address = null;
//        while (true) {

        try {
            socket = new Socket("127.0.0.1", 5000); // 서버가 열어놓은 포트 입력
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            outGoing = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//            System.out.println(socket.getOutputStream());
            System.out.println("** 서버에 접속하였습니다. **");
        } catch (IOException e) {
            System.out.println("포트가 열려있지 않습니다.");
        }

        try {
            while (true) {

                System.out.print("ID를 입력하세요 : ");
                String id = keyboardInput.readLine(); //키보드로부터 입력
                outGoing.println(id); //서버로 데이터 전송
                System.out.print("PASS를 입력하세요 : ");
                String pw = keyboardInput.readLine();
                outGoing.println(pw);
                outGoing.flush(); // 사용 -> 꺼짐
                String serverReturn = inputStream.readLine(); //서버로부터 되돌아오는 데이터를 읽어준다.

                System.out.println(serverReturn); //서버로부터 돌아온 메시지

                if (serverReturn.equals("** ID 또는 PASS가 틀렸습니다. **")) {
                    outGoing.flush(); // 사용 -> 꺼짐
                } else if (serverReturn.equals("** FTP 서버에 접속하였습니다. **")) {
                    System.out.println("LOGIN SUCCESSED!");
                    while (true)
                        prompt(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        OutputStream os = socket.getOutputStream();
//        BufferedOutputStream bor = new BufferedOutputStream(os);
//        DataOutputStream dos = new DataOutputStream(bor);
//
//        File f1 = new File("D:");
//        FileInputStream fis = new FileInputStream(f1);
//
//        dos.writeUTF(f1.getName());
//
//        int readsize = 0;
//        byte[] bytes = new byte[1024];
//
//        while ((readsize = fis.read(bytes)) != -1) {
//            dos.write(bytes, 0, readsize);
//        }

    }
//    }


    static void prompt(Socket socket) throws IOException {
        String cmd = scanner.nextLine();
        if (cmd.startsWith("/업로드")) {
            upload(socket, cmd.split(" "));
        } else if (cmd.startsWith("/파일목록")) {
            requestFileList(socket);
        }
        else if (cmd.startsWith("/다운로드")) {
            download(socket, cmd.split(" "));
        }
        else if(cmd.startsWith("/접속종료")){
            socket.close();
            System.out.println("프로그램이 종료됩니다.");
        }
        else {
            System.out.println("없는 명령어입니다");
        }

    }

    static void upload(Socket socket, String[] tokens) throws IOException {
        BufferedReader keyboardInput = null;
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Protocol protocol = new Protocol(socket.getOutputStream(),
                socket.getInputStream(),
                bf);
        File fileToSend = new File(tokens[1]); //1
        String dstName = tokens.length == 3 ? tokens[2] : tokens[1];
        protocol.sendFile(fileToSend, dstName);
        System.out.println(dstName + " 파일이 업로드 되었습니다.");
    }

    static void download(Socket socket, String[] tokens) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Protocol protocol = new Protocol(socket.getOutputStream(),
                socket.getInputStream(),
                bf);

        File fileToDown = new File(tokens[1]);
        String dstName = tokens.length == 3 ? tokens[2] : tokens[1];
        protocol.sendFile(fileToDown, dstName);
        System.out.println(dstName + " 파일이 다운로드 되었습니다.");

    }

    static void requestFileList(Socket socket) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Protocol protocol = new Protocol(socket.getOutputStream(),
                socket.getInputStream(),
                bf);

        List<Protocol.FileInfo> result;
        result = protocol.requestFileList();

        result.stream().forEach((item) -> {
            System.out.printf(" * %s %s\n", item.name, item.size);
        });
    }

}
