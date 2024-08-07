package com.mrymw.sudoku;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SudokuCell {
    public static boolean isSafe(List<List<Integer>> sudoku, int row, int col, int i) {
        for(int j=0; j< sudoku.size(); j++){
            if(sudoku.get(row).get(j) == i){
                return false;
            }
        } for (int k=0; k<sudoku.size(); k++){
            if (sudoku.get(k).get(col)==i){
                return false;
            }
        }
        int rows = row-(row%3);
        int cols = col-(col%3);
        for (int l=rows; l<rows+3; l++){
            for(int m=cols; m<cols+3; m++){
                if (sudoku.get(l).get(m)==i) {
                    return false;
                }
            }
        }
        return true;
    }
}
