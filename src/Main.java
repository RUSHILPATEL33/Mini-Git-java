import commands.AddCommand;
import commands.CommitCommand;

public class Main {

    public static void main(String[] args) throws Exception {

        if(args.length == 0) {
            System.out.println("No command given");
            return;
        }

        switch(args[0]) {

            case "add":
                AddCommand.run(args[1]);
                break;

            case "commit":
                CommitCommand.run(args[1]);
                break;

            default:
                System.out.println("Invalid command");
        }
    }
}