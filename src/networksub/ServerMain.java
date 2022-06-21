package networksub;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerMain {

    public static void main(String[] args) throws IOException {

        Socket socket = null; //클라이언트와 통신하기 위한 소켓
        ServerSocket serverSocket = null; //서버 생성을 위한 server 소켓
        BufferedReader inputData = null; //클라이언트로 부터 데이터를 읽어들이기 위한 입력스트림
        PrintWriter outGoing = null; //클라이언트로 데이터를 내보내기 위한 출력 스트림

        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            System.out.println("서버 연결");
        }


        try {
            System.out.println("서버 오픈");

            socket = serverSocket.accept(); //서버 생성. 클라이언트 접속 대기

            inputData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outGoing = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

//                String clientMessage = null;
//                clientMessage = inputData.readLine(); //client로 부터 데이터를 읽어온다.

            while(true) {
                String id = inputData.readLine();
                String pw = inputData.readLine();

                if (id.equals("admin") && pw.equals("1234")) {
                    outGoing.println("** FTP 서버에 접속하였습니다. **");
                    outGoing.flush();
                    break;
                } else {
                    outGoing.println("** ID 또는 PASS가 틀렸습니다. **");
                    outGoing.flush();
                    continue;
                }
            }
            Protocol protocol = new Protocol(
                    socket.getOutputStream(),
                    socket.getInputStream(),
                    inputData
            );

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            while (true) {
                String[] received = inputData.readLine().split("\\|");
                System.out.println(received);

                switch (received[0]) {
                    case "FILE_SEND_INIT":
                        protocol.receiveFile(received[1], Integer.parseInt(received[2]));
                        break;
                    case "FILE_LIST":
                        protocol.responseFileList(new File("."));
                        break;
                    case "FILE_DOWNLOAD":
                        protocol.receiveFile(received[1], Integer.parseInt(received[2]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Client와 연결되지 않습니다.");
        } catch (ArrayIndexOutOfBoundsException ignored) {}


//        protocol.receiveFile(received[1], Integer.parseInt(received[2]));

        //파일보내기 - 업로드

//            serverSocket = new ServerSocket(5000);
//            socket = serverSocket.accept();
//
//            InputStream is = socket.getInputStream();
//            BufferedInputStream bir = new BufferedInputStream(is);
//            DataInputStream dis = new DataInputStream(bir);
//
////        String filename = dis.readUTF();
//            String filefolder = "D:\\2103박소영\\Network";
//
//            FileOutputStream fos = new FileOutputStream(filefolder);
//
//            int readsize;
//            byte[] bytes = new byte[1024];
//
//            while ((readsize = dis.read(bytes)) != -1) {
//                fos.write(bytes, 0, readsize);
//            }


    }

}
