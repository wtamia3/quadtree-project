# Quadtree Project

## Description

This project implements a **Quadtree** data structure in Java. A Quadtree is a tree data structure used for spatial partitioning, where each node in the tree represents a rectangular region of space and can hold up to five rectangles. Once a node exceeds this capacity, it splits into four child nodes (internal nodes). The application supports several operations such as inserting, deleting, finding, and dumping the state of the quadtree.

The project is designed to help visualize and manage 2D spatial data using a quadtree, which is useful for tasks like collision detection, spatial indexing, and managing geographical data.

## Features

- **Insert Rectangles**: Insert rectangles into the quadtree by specifying their position (X, Y) and dimensions (length and width).
- **Delete Rectangles**: Remove rectangles from the quadtree based on their position.
- **Find Rectangles**: Retrieve and display a rectangle at a given position (X, Y).
- **Dump Tree**: Output the current structure of the quadtree for visualization, showing nodes and their contained rectangles.

## Technologies

- **Java 11** (or later) – The project is developed using Java 11.
- **Object-Oriented Programming (OOP)** principles such as inheritance, polymorphism, encapsulation, and modularity.
- **JUnit 5** – For unit testing and ensuring the correctness of operations.
- **Quadtree Data Structure** – Used to efficiently manage spatial data and perform operations like insertion, deletion, and searching.

## Project Structure

This project follows a standard Maven-style directory layout:

```plaintext
your_project_folder/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── CommandProcessor.java   # Handles processing of commands
│   │       ├── Main.java               # Entry point of the program
│   │       ├── Quadtree.java           # Quadtree data structure implementation
│   │       ├── LeafNode.java           # Leaf node in the quadtree
│   │       ├── InternalNode.java       # Internal node in the quadtree
│   │       ├── Rectangle.java          # Rectangle object representing each inserted shape
│   │       └── ... (other classes)
├── src/
│   └── test/
│       └── java/
│           ├── QuadtreeTest.java       # Unit tests for the Quadtree class
│           ├── LeafNodeTest.java       # Unit tests for the LeafNode class
│           └── ... (other test classes)
└── commands.txt                        # Command file for running the program
