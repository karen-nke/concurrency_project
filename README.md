# Concurrency Programming Exercise in Java

## Overview
This project is part of coursework for SCC 211, focusing on fundamental concepts in concurrency using Java. The primary goal is to implement a multithreaded Java program that allows concurrent addition and removal of items from an inventory while managing race conditions and critical sections.

## Files
- **InventoryMain.java**: Main file to launch the application.
- **Other Java Files**: Files containing the implementation of the multithreaded program.

## How to Compile and Run
1. **Compilation**: Extract the contents of the zip file into a folder. Open a command line in that folder and run the following command to compile the application.
    ```bash
    javac InventoryMain.java
    ```
   This should generate the necessary .class files in the same folder.

2. **Execution**: Run the compiled program with appropriate arguments. For example, to perform 5 add operations, 10 remove operations, and ensure correct final inventory size, use the following command:
    ```bash
    java InventoryMain 5 10 0
    ```

## Command-Line Arguments
- **First Argument**: Number of add operations (threads launched for adding items).
- **Second Argument**: Number of remove operations (threads launched for removing items).
- **Third Argument**: Bug flag (0 for correct inventory size, 1 for intentionally incorrect size).

## Output
The program will print a sequence of statements for each operation, including the operation performed and the resulting inventory size. The final inventory size will be displayed after all add and remove threads have finished.

_Coursework for SCC 211(UK)  & CSC2104(MY) Operating System Fundamentals (August 2022 - December 2022)_
