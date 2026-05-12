import commands.AddCommand;
import commands.CommitCommand;
import commands.LogCommand;
import commands.StatusCommand;
import commands.CheckoutCommand;

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
            
            case "log":
                LogCommand.run();
                break;
            case "status":
                StatusCommand.run();
                break;
            case "checkout":
                CheckoutCommand.run(args[1]);
                break;

            default:
                System.out.println("Invalid command");
        }
    }
}