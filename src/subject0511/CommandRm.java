package subject0511;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CommandRm extends AbstractCommand {

    public CommandRm(File currentDirectory, String commandLine) {
        super(currentDirectory, commandLine);
    }

    @Override
    public File executeCommand() {
        String path = commandLine.replace("rm ", "");
        File file = new File(currentDirectory + "/" + path);
        if (!file.exists()) {
            // 파일이 존재하지 않을 때
            System.out.println("파일을 찾을 수 없습니다.");
            return currentDirectory;
        }

        System.out.print("정말로 삭제하시겠습니까? (Y/N) ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            String result = (file.delete()) ? "삭제되었습니다." : "삭제되지 않았습니다.";
            System.out.printf("%s%n", result);
        }
        return currentDirectory;
    }
}
