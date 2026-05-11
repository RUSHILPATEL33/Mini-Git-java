import java.io.*;
import java.nio.file.*;
import utils.HashUtil;

public class Main {

    public static void main(String[] args) throws Exception {

        if(args.length > 1 && args[0].equals("add")) {

            String filename = args[1];

            File file = new File(filename);

            if(!file.exists()) {
                System.out.println("File does not exist");
                return;
            }

            String content = new String(Files.readAllBytes(file.toPath()));

            String hashString = HashUtil.sha1(content);

            File objectFile = new File(".mygit/objects/" + hashString);

            Files.write(objectFile.toPath(), content.getBytes());

            System.out.println("Added file: " + filename);
            System.out.println("Hash: " + hashString);
        }
    }
}