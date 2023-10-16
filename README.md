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

## Evaluation Criteria
- **Input Handling**: Up to 2 points for correctly taking input via command line arguments.
- **Thread Launching**: Up to 10 marks for launching threads corresponding to the specified number of add and remove operations.
- **Correct Output (Bug Flag = 0)**: Up to 5 marks for producing the correct result.
- **Incorrect Output (Bug Flag = 1)**: Up to 3 marks for intentionally producing an incorrect result.

## Suggested Steps for Completion
- **Week 1**: Implement a multithreaded program, initially incrementing a shared counter. Extend to maintain a shared inventory size using a Warehouse object.
- **Week 2**: Add command line arguments for the number of remove operations. Implement synchronization to prevent race conditions.
- **Week 3**: Introduce a bug flag. If 0, execute with synchronization; if 1, execute without synchronization to manifest a race condition.

## Submission
Submit a zip file containing all source code (.java) files with no subfolders. Include a Readme.txt with your full name and student ID number.

**Note**: Ensure the program handles edge cases and provides the desired output as described in the program specification.
