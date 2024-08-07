package com.mrymw.application;

import com.mrymw.sudoku.Sudoku;
import com.mrymw.sudoku.SudokuSolver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String filename = "puzzle";

        Board unsolvedBoard = new Board();
        Board solvedBoard = new Board();

        List<List<String>> puzzle = Sudoku.readSudokuFile(filename);
        unsolvedBoard.displayPuzzle(puzzle);

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<Integer>> intPuzzle = SudokuSolver.convertToIntegerList(puzzle);
                if (SudokuSolver.solveSudoku(intPuzzle)) {
                    Sudoku.saveSolvedSudoku(intPuzzle, filename); // Save solution
                    solvedBoard.displaySolvedValues(intPuzzle); // Update the solved board with solved values
                    JOptionPane.showMessageDialog(frame, "Puzzle solved and saved to puzzle-solution.txt!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No solution exists for the provided puzzle.");
                }
            }
        });

        // Create a panel for the boards and button
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 0)); // 3 columns with space between

        panel.add(unsolvedBoard);
        panel.add(solveButton); // Add button to the center
        panel.add(solvedBoard);

        // Add the main panel to the frame
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
