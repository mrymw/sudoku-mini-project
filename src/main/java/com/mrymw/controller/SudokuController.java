package com.mrymw.controller;

import com.mrymw.sudoku.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mrymw.sudoku.Sudoku.displaySolvedSudoku;
import static com.mrymw.sudoku.Sudoku.displaySudoku;

@Controller
@RequestMapping("/api")
public class SudokuController {
    @Autowired
    private Sudoku sudoku;
    @Autowired
    private SudokuSolver sudokuSolver;
    @Autowired
    private SudokuCell sudokuCell;
    @PostMapping("/load")
    public ResponseEntity<List<List<Integer>>> readSudoku(@RequestBody SudokuRequest request) {
        String filename = request.getFilename(); // Extract filename from the request
        List<List<String>> puzzle = Sudoku.readSudokuFile(filename);
        List<List<Integer>> intPuzzle = SudokuSolver.convertToIntegerList(puzzle);
        displaySudoku(puzzle, filename);
        return ResponseEntity.ok(intPuzzle);
    }
    @PostMapping("/solve")
    public ResponseEntity<List<List<Integer>>> solveSudoku(@RequestBody SudokuRequest request) {
        String filename = request.getFilename(); // Extract filename from the request
        List<List<String>> puzzle = Sudoku.readSudokuFile(filename);
        List<List<Integer>> intPuzzle = SudokuSolver.convertToIntegerList(puzzle);
        SudokuSolver.solveSudoku(intPuzzle);
        displaySolvedSudoku(intPuzzle, filename);
        boolean isSolved = SudokuSolver.solveSudoku(intPuzzle);
        if (isSolved) {
            return ResponseEntity.ok(intPuzzle);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveSudoku(@RequestBody SudokuRequest request) {
        String filename = request.getFilename();
        List<List<String>> puzzle = Sudoku.readSudokuFile(filename);
        List<List<Integer>> intPuzzle = SudokuSolver.convertToIntegerList(puzzle);
        SudokuSolver.solveSudoku(intPuzzle);
        Sudoku.saveSolvedSudoku(intPuzzle, filename);
        return ResponseEntity.ok("Sudoku saved successfully.");
    }
}

