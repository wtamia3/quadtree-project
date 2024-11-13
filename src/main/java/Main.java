package src.main.java;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <commands_file>");
            return;
        }

        // Create an instance of CommandProcessor
        CommandProcessor processor = new CommandProcessor();
        
        // Call processCommands with the file path argument
        processor.processCommands(args[0]);
    }
}
