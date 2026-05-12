package commands;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckoutCommand {

    public static void run(String commitId) throws Exception {

        File commitFile =
            new File(".mygit/commits/" + commitId);

        if(!commitFile.exists()) {
            System.out.println("Commit not found");
            return;
        }

        String content = new String(
            Files.readAllBytes(commitFile.toPath())
        );

        String[] lines = content.split("\n");

        for(String line : lines) {

            // skip metadata
            if(
                line.startsWith("Message:")
                || line.startsWith("Time:")
                || line.trim().isEmpty()
            ) {
                continue;
            }

            String[] parts = line.split(":");

            String filename = parts[0];
            String hash = parts[1];

            File objectFile =
                new File(".mygit/objects/" + hash);

            String fileContent = new String(
                Files.readAllBytes(objectFile.toPath())
            );

            Files.write(
                Paths.get(filename),
                fileContent.getBytes()
            );

            System.out.println(
                "Restored: " + filename
            );
        }
        Files.write(
            Paths.get(".mygit/HEAD"),
            commitId.getBytes()
        );
    }
}