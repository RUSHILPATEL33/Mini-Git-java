package commands;

import java.io.File;
import java.nio.file.Files;

public class StatusCommand{
    public static void run() throws Exception{
        File indexFile = new File(".mygit/index");
        if(!indexFile.exists()) {
            System.out.println("No files staged");
            return;
        }
        String content = new String(Files.readAllBytes(indexFile.toPath()));
        System.out.println("=== STAGED FILES ===");
        String[] lines = content.split("\n");

        for(String line : lines) {
            if(line.trim().length()==0)
                continue;
            String[] parts = line.split(":");
            System.out.println(parts[0]);
        }
    }
}