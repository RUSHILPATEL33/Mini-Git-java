package commands;
import java.io.*;
import java.nio.file.*;
import utils.HashUtil;

public class AddCommand{
    public static void run(String filename) throws Exception{
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        String content = new String(Files.readAllBytes(file.toPath()));

        String hashString = HashUtil.sha1(content);

        File objectFile = new File(".mygit/objects/" + hashString);

        Files.write(objectFile.toPath(), content.getBytes());

        Files.write(
            Paths.get(".mygit/index"),
            (filename + ":" + hashString + "\n").getBytes(),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
        );
        System.out.println("Added file:" + filename );
        System.out.println("Hash:"+ hashString);
    }
}