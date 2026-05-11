import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;

public class Main {

    public static void main(String[] args) throws Exception {

        // INIT COMMAND
        if (args.length > 0 && args[0].equals("init")) {

            File folder = new File(".mygit");

            if (folder.mkdir()) {

                // create objects folder
                new File(".mygit/objects").mkdir();

                System.out.println("Initialized empty MyGit repository");

            } else {
                System.out.println("Repository already exists");
            }
        }
        else if(args.length>1 && args[0].equals("add")){
            String filename = args[1];  
            File file = new File(filename);
            if(!file.exists()){
                System.out.println("File does not exist");
                return;
            }
            //Reads file contents
            String content = new String(Files.readAllBytes(file.toPath()));
                 // Generate SHA-1 hash
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(content.getBytes());

            StringBuilder hash = new StringBuilder();

            for (byte b : hashBytes) {
                hash.append(String.format("%02x", b));
            }

            String hashString = hash.toString();

            // Store file in objects folder
            File objectFile = new File(".mygit/objects/" + hashString);

            Files.write(objectFile.toPath(), content.getBytes());

            System.out.println("Added file: " + filename);
            System.out.println("Hash: " + hashString);
        }

        else {
            System.out.println("Invalid command");
        }
    }
}