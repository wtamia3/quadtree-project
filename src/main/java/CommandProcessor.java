package src.main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandProcessor {
    private Quadtree quadtree;

    public CommandProcessor() {
        // Initialize the quadtree with specified boundaries.
        quadtree = new Quadtree(-50, 50, -50, 50);
    }

    public void processCommands(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseAndExecute(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private void parseAndExecute(String command) {
        String[] parts = command.split(" ");
        String action = parts[0].toLowerCase();

        switch (action) {
            case "insert":
                handleInsert(parts);
                break;

            case "delete":
                handleDelete(parts);
                break;

            case "find":
                handleFind(parts);
                break;

            case "dump":
                quadtree.dump();
                break;

            default:
                System.out.println("Unknown command: " + action);
        }
    }

    private void handleInsert(String[] parts) {
        if (parts.length == 5) {
            try {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                int width = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                Rectangle rect = new Rectangle(x, y, width, height);
                quadtree.insert(rect);
                System.out.println("Inserted: " + rect);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers in insert command.");
            }
        } else {
            System.out.println("Invalid format for insert command. Expected: insert <x> <y> <width> <height>");
        }
    }

    private void handleDelete(String[] parts) {
        if (parts.length == 5) {
            try {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                int width = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);
                Rectangle rect = new Rectangle(x, y, width, height);
                quadtree.delete(rect);
                System.out.println("Deleted: " + rect);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers in delete command.");
            }
        } else {
            System.out.println("Invalid format for delete command. Expected: delete <x> <y> <width> <height>");
        }
    }

    private void handleFind(String[] parts) {
        if (parts.length == 3) {
            try {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                Rectangle found = quadtree.find(x, y);
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("No rectangle found at (" + x + ", " + y + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers in find command.");
            }
        } else {
            System.out.println("Invalid format for find command. Expected: find <x> <y>");
        }
    }
}
