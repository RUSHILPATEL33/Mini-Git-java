package commands;

import java.io.File;
import java.nio.file.Files;

public class LogCommand{
    public static void run() throws Exception{
        File commitsFolder = new File(".mygit/commits");
        File[] commits = commitsFolder.listFiles();

        if(commits == null || commits.length == 0){
            System.out.println("No commits found");
            return;
        }
        for(File commit : commits){
            String content = new String(Files.readAllBytes(commit.toPath()));
            System.out.println("--------------------------");
            System.out.println("Commit ID: " + commit.getName());
            System.out.println(content);
        }
    }
}