package subject0511;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommandCd extends AbstractCommand {

    public CommandCd(File currentDirectory, String commandLine){
        super(currentDirectory, commandLine);
    }

    public File joinPath(String newPath) {
        File newPathFile = new File(newPath);
        //System.out.println(newPathFile.getAbsolutePath());
        if(newPathFile.isAbsolute()) {
            return newPathFile;
        } else {
          return new File(currentDirectory.getAbsolutePath() + "/" + newPath);
        }
    }

    @Override
    public File executeCommand(){
        String[] tokens = commandLine.split(" ");

        if(tokens.length != 2) {
            System.out.println("올바르지 않은 경로");
            return currentDirectory;
        }
        String pathToMove = tokens[1];


        File newPathResult = joinPath(pathToMove);
        try {
            //System.out.println("move to: " + newPathResult.getCanonicalPath());

            if(!newPathResult.exists()) {
                System.out.println("없는 경로입니다");
                return currentDirectory;
            }
            return newPathResult.getCanonicalFile();
        } catch(IOException ex) {
            System.out.println("없는 경로입니다");
            return currentDirectory;
        }

    }
}
