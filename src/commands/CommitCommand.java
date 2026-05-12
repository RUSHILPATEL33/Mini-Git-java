package commands;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;

import utils.HashUtil;

public class CommitCommand{
    public static void run(String message) throws Exception{
        File indexFile = new File(".mygit/index");
        if (!indexFile.exists()) {
            System.out.println("No changes to commit.");
            return;
        }
        String stagedData = new String(
            Files.readAllBytes(indexFile.toPath())
        );

        String indexContent = new String(Files.readAllBytes(indexFile.toPath()));
        String commitContent = 
            "Message: " + message + "\n" +
            "Time: " + LocalDateTime.now() + "\n\n" +
            stagedData;
        
        String commitId = HashUtil.sha1(commitContent);
        new File(".mygit/commits").mkdirs();

        File commitFile = new File(".mygit/commits/" + commitId);
        Files.write(commitFile.toPath(), commitContent.getBytes());
        Files.write(Paths.get(".mygit/HEAD"), commitId.getBytes());

        indexFile.delete();

        System.out.println("Commit successful!");
        System.out.println("Commit ID: " + commitId);
    }
}