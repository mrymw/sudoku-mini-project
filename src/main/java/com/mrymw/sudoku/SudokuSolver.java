package com.mrymw.sudoku;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.mrymw.sudoku.SudokuCell.*;
@Service
public class SudokuSolver {
    public static List<List<Integer>> convertToIntegerList(List<List<String>> puzzleList) {
        List<List<Integer>> puzzle = new ArrayList<>();
        for (List<String> row : puzzleList) {
            List<Integer> intRow = new ArrayList<>();
            for (String value : row) {
                if (value.equals(".")) {
                    intRow.add(0);
                } else {
                    intRow.add(Integer.parseInt(value));
                }
            }
            puzzle.add(intRow);
        }
        return puzzle;
    }
    public static boolean solveSudoku(List<List<Integer>> sudoku){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(sudoku.get(i).get(j)==0){
                    for(int num = 1; num <=9; num++){
                        if(isSafe(sudoku,i,j, num)) {
                            sudoku.get(i).set(j, num);
                            if (solveSudoku(sudoku)) {
                                return true;
                            }
                            sudoku.get(i).set(j,0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
