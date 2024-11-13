# Quadtree Project

## Description
This project implements a Quadtree data structure in Java. It allows for efficient storage, searching, and deletion of rectangular objects in a 2D space. The application supports several operations such as inserting, deleting, finding, and dumping the state of the quadtree.

The project is intended to help visualize and manage 2D spatial data using a quadtree, with the ability to handle dynamic insertion and deletion of objects.

## Features
- **Insert** rectangles into the quadtree.
- **Delete** rectangles from the quadtree.
- **Find** rectangles based on their coordinates.
- **Dump** the current state of the quadtree for visualization.

## Technologies
- Java 11 (or later)
- Object-Oriented Programming (OOP) principles
- Quadtree data structure

## Project Structure

```plaintext
your_project_folder/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── CommandProcessor.java   # Handles processing of commands
│   │       ├── Main.java               # Entry point of the program
│   │       ├── Quadtree.java           # Quadtree data structure
│   │       ├── LeafNode.java           # Leaf node in the quadtree
│   │       ├── InternalNode.java       # Internal node in the quadtree
│   │       ├── Rectangle.java          # Rectangle object
│   │       └── ... (other classes)
├── src/
│   └── test/
│       └── java/
│           ├── QuadtreeTest.java       # Unit tests for quadtree
│           ├── LeafNodeTest.java       # Unit tests for LeafNode
│           └── ... (other test classes)
└── commands.txt                        # Command file for running the program
