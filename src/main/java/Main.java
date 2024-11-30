import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <file.cmmd>");
            return;
        }

        String fileName = args[0];
        Quadtree quadtree = new Quadtree();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                processCommand(line, quadtree);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processCommand(String command, Quadtree quadtree) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "Insert":
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                double l = Double.parseDouble(parts[3]);
                double w = Double.parseDouble(parts[4]);
                quadtree.insertRectangle(x, y, l, w);
                break;
            case "Find":
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                quadtree.findRectangle(x, y);
                break;
            case "Delete":
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                quadtree.deleteRectangle(x, y);
                break;
            case "Update":
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                l = Double.parseDouble(parts[3]);
                w = Double.parseDouble(parts[4]);
                quadtree.updateRectangle(x, y, l, w);
                break;
            case "Dump":
                quadtree.dumpTree();
                break;
            default:
                System.out.println("Invalid command: " + command);
                break;
        }
    }
}

