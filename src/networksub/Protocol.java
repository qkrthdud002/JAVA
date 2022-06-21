package networksub;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Protocol {
    private OutputStream outputStream;
    private InputStream inputStream;
    private BufferedReader headerReader;

    public Protocol(OutputStream outputStream, InputStream inputStream, BufferedReader headerReader) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
        this.headerReader = headerReader;
    }

    // 파일 전송
    public void sendFile(File fileToSend) throws IOException {
        sendFile(fileToSend, fileToSend.getName());
    }

    // 파일 전송
    public void sendFile(File fileToSend, String dstName) throws IOException {
        PrintWriter pw = new PrintWriter(outputStream, true);

        FileInputStream fileReader = new FileInputStream(fileToSend);
        long fileSize = fileToSend.length();
        DataOutputStream dos = new DataOutputStream(outputStream);
        pw.println(String.format("FILE_SEND_INIT|%s|%d", dstName, fileSize));

        byte[] fileBuffer = new byte[1024];

        int bufferSize;
        while((bufferSize = fileReader.read(fileBuffer)) != -1) {
            byte[] header = String.format("FILE_SEND_SLICED|%d\n", bufferSize).getBytes();
            byte[] packet = new byte[header.length + bufferSize];

            System.arraycopy(header, 0, packet, 0, header.length);
            System.out.println(new String(header));
            System.out.printf("file to %d~%d\n", header.length, header.length + bufferSize);
            System.arraycopy(fileBuffer, 0, packet, header.length, bufferSize);
            this.outputStream.write(packet); //.wirte
            this.outputStream.flush();
            System.out.printf("전송된 Chunk Size: %d\n", packet.length);
        }
    }

//    public void downFile(File fileToDown) throws IOException{
//        PrintWriter pw = new PrintWriter(outputStream, true);
//
//        FileInputStream fileReader = new FileInputStream(fileToDown);
//        long fileSize = fileToDown.length();
//        DataOutputStream dos = new DataOutputStream(outputStream);
//
//    }

    private int parsePayloadLength() throws IOException {
        String header = this.headerReader.readLine();
        return Integer.parseInt(header.split("\\|")[3]); //3
    }

    // 파일 수신
    public void receiveFile(String dstName, long fileAllSize) throws IOException {
        File downloadFile = new File(dstName);
        FileOutputStream fileWriter = new FileOutputStream(downloadFile);

        long receivedChunkSize = 0;
        int payloadLength;
        while((payloadLength = parsePayloadLength()) > 0) {
            byte[] chunk = this.inputStream.readNBytes(payloadLength);
            fileWriter.write(chunk, 0, payloadLength);

            System.out.printf("Received Chunk Size: %d\n", payloadLength);
            receivedChunkSize += payloadLength;
            if(receivedChunkSize == fileAllSize) {
                System.out.println("모든 청크를 수신했습니다.");
                break;
            }
        }
        fileWriter.close();
    }

    //파일 목록 응답
    public void responseFileList(File currentDirectory) throws IOException {
        File[] files = currentDirectory.listFiles(); //File[] files
        StringBuilder sb = new StringBuilder();
        for(File element : files) {
            sb.append(String.format("%s:%s#", element.getName(), getFileSize(element)));
        }
        if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println(sb.toString());
    }

    static class FileInfo {
        public FileInfo(String name, String size) {
            this.name = name;
            this.size = size;
        }

        public String name;
        public String size;
    }

    //파일 존재 여부 확인 - client. 서버 파일 목록 가져오기-> 서버에 저장할 파일 이름이랑 기존 파일 목록 비교 -> 이미 존재하면 덮어씌우겠냐 물어보기 -> 예하면 기존에 있는 데이터는 지우고 덮어씌우기 -> 아니요하면 그냥 끝내기
//    public void existFile() throws IOException {
//        pw.println(header);
//        String response = this.headerReader.readLine(); //this.headerReader
//            if(response.startsWith(header)){
//                pw.println("파일이 이미 있습니다. 덮어쓰기 하실건가요?? (Yes : 덮어쓰기" +
//                        " / No : 업로드 취소)");
//                response = this.headerReader.readLine();
//                if(response.startsWith("Yes") || response.startsWith("yes")){
//    //                List<FileInfo> result = new ArrayList<>();
//    //                for(String data: response.split("#")) {
//    //                    String[] tokens = data.split(":");
//    //                    result.add(new FileInfo(tokens[0], tokens[1]));
//    //                }
//
//                }
//                else{
//                    pw.println("덮어쓰기 하지 않음.");
//                }
//        }
//    }

    public List<FileInfo> requestFileList() throws IOException {

        String header = "FILE_LIST";
        PrintWriter pw = new PrintWriter(outputStream, true);
        pw.println(header);

//        pw.println(responseFileList());

        String response = this.headerReader.readLine(); //this.headerReader
//        if(response.startsWith(header)){
//            pw.println("파일이 이미 있습니다. 덮어쓰기 하실건가요?? (Yes : 덮어쓰기" +
//                    " / No : 업로드 취소)");
//            response = this.headerReader.readLine();
//            if(response.startsWith("Yes") || response.startsWith("yes")){
////                List<FileInfo> result = new ArrayList<>();
////                for(String data: response.split("#")) {
////                    String[] tokens = data.split(":");
////                    result.add(new FileInfo(tokens[0], tokens[1]));
////                }
//
//            }
//            else{
//                pw.println("덮어쓰기 하지 않음.");
//            }
//        }
        List<FileInfo> result = new ArrayList<>();
        for(String data: response.split("#")) {
            String[] tokens = data.split(":");
            result.add(new FileInfo(tokens[0], tokens[1]));
        }

        return result;
    }

    public String getFileSize(File file){
        final String[] units = { "bytes", "Kb", "Mb", "Gb", "Tb" };
        long size = file.length();
        for(int exp = 0; exp < units.length; exp++) {
            int divided = (int) (size / Math.pow(1024, exp));
            if(divided < 1024) {
                return String.format("%d%s", divided, units[exp]);
            }
        }
        return String.format("%d%c", size, units[0]);
    }

    //파일 다운로드
//    public List<FileInfo> downLoadFile() throws IOException{
//        String header = "FILE_DOWNLOAD";
//        if(getFileSize())
//    }

}