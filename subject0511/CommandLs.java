package subject0511;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class CommandLs extends AbstractCommand {

    public CommandLs(File currentDirectory, String commandLine){
        super(currentDirectory, commandLine);
    }

    public String getFormattedFileSize(File file) {
        final char[] units = { ' ', 'K', 'M', 'G', 'T' };
        long size = file.length();
        for(int exp = 0; exp < units.length; exp++) {
            int divided = (int) (size / Math.pow(1024, exp));
            if(divided < 1024) {
                return String.format("%d%c", divided, units[exp]);
            }
        }
        return String.format("%d%c", size, units[0]);
    }

    @Override
    public File executeCommand(){
        //int cnt=0;
        File[] list = currentDirectory.listFiles();
        for(File file : list) {
            String modifiedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());
            //System.out.printf("%s %s %s \n", modifiedAt, file.isDirectory() ? "DIR" : file.length(), file.getName());

            //long size = file.length();

            System.out.printf("%s ", modifiedAt);
            System.out.printf("%6s ", file.isDirectory() ? "<DIR>" : "");
            System.out.printf("%5s ", file.isFile() ? getFormattedFileSize(file) : "");

            System.out.printf("%s\n", file.getName());

        }

        return currentDirectory;
    }

}
