package com.mrymw.application;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Board extends JPanel {
    private NineSquare[] gridSquares = new NineSquare[9];
    private Color[] bgs = {Color.blue.brighter(), Color.gray};

    public Board() {
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < gridSquares.length; i++) {
            gridSquares[i] = new NineSquare(bgs[i % 2]);
            add(gridSquares[i]);
        }
    }

    public void displayPuzzle(List<List<String>> puzzle) {
        for (int i = 0; i < puzzle.size(); i++) {
            gridSquares[i].setValues(puzzle.get(i));
        }
    }
    public void displaySolvedValues(List<List<Integer>> solvedValues) {
        for (int i = 0; i < solvedValues.size(); i++) {
            List<String> stringValues = new ArrayList<>();
            for (Integer value : solvedValues.get(i)) {
                stringValues.add(value == 0 ? "." : value.toString()); // Use "." for empty cells
            }
            gridSquares[i].setValues(stringValues);
        }
    }



    public List<List<Integer>> getSudokuValues() {
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                int value = gridSquares[i].fields[j].getText().isEmpty() ? 0 : Integer.parseInt(gridSquares[i].fields[j].getText());
                row.add(value);
            }
            values.add(row);
        }
        return values;
    }


}
