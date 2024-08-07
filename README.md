# Sudoku Mini Project

## Overview

The Sudoku Solver Application is a Java-based graphical user interface (GUI) program that allows users to input a Sudoku puzzle, solve it, and view both the original and solved puzzles side by side. This application demonstrates the use of Java Swing for GUI development, alongside logic for solving Sudoku puzzles programmatically.

## Features

- **User-friendly Interface**: A simple GUI that displays the Sudoku puzzle in a grid format.
- **Input Puzzle**: Ability to input Sudoku puzzles through a text file.
- **Solve Button**: A button that triggers the solving algorithm and displays the solution.
- **Display Solved Puzzle**: View the solved puzzle in a separate grid beside the original puzzle.
- **File Handling**: Automatically reads the puzzle from a file and saves the solution to a new file.

## Technologies Used

- Java
- Java Swing (for GUI)
- Java Collections (for data management)
- PostMan

## API Endpoints

The application provides a RESTful API for loading, solving, and saving Sudoku puzzles. Below are the available endpoints:

| Request Type | URL                | Functionality                                     | Access Level       |
|--------------|--------------------|--------------------------------------------------|---------------------|
| POST         | `/api/load`        | Loads a Sudoku puzzle from a file and returns it as an integer list. | Public              |
| POST         | `/api/solve`       | Solves the loaded Sudoku puzzle and returns the solution as an integer list. | Public              |
| POST         | `/api/save`        | Saves the solved Sudoku puzzle to a file.       | Public              |

### Example Requests with Postman

1. **Load Sudoku Puzzle**:
   - **Request URL**: `http://localhost:8080/api/load`
   - **Body (JSON)**:
     ```json
     {
       "filename": "puzzle"
     }
     ```

2. **Solve Sudoku Puzzle**:
   - **Request URL**: `http://localhost:8080/api/solve`
   - **Body (JSON)**:
     ```json
     {
       "filename": "puzzle"
     }
     ```

3. **Save Solved Sudoku Puzzle**:
   - **Request URL**: `http://localhost:8080/api/save`
   - **Body (JSON)**:
     ```json
     {
       "filename": "puzzle"
     }
     ```

## Notes

- Ensure the filenames provided in the requests match the actual files in the project directory.
- The application must be running for the endpoints to be accessible via Postman.


## Getting Started

### Prerequisites

- JDK 17 or higher
- An IDE (such as IntelliJ IDEA or Eclipse) for Java development

### Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://git.generalassemb.ly/mrymw/mini-project-sudoku-puzzle
  
