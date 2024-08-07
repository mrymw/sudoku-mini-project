package com.mrymw.sudoku;
import java.util.List;
import static com.mrymw.sudoku.Sudoku.*;
import static com.mrymw.sudoku.SudokuSolver.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "puzzle";
        List<List<String>> puzzle = readSudokuFile(fileName);
        displaySudoku(puzzle, fileName);
        List<List<Integer>> integerPuzzle = convertToIntegerList(puzzle);
        solveSudoku(integerPuzzle);
        displaySolvedSudoku(integerPuzzle, fileName);
        saveSolvedSudoku(integerPuzzle, fileName);
    }
}
