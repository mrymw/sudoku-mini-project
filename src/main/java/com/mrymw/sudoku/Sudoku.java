package com.mrymw.sudoku;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
@Service
public class Sudoku {
    public static List<List<String>> readSudokuFile(String filename) {
        String newfilename = filename + ".txt";
        List<List<String>> puzzle = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(newfilename))) {
            String numbers;
            while ((numbers=bufferedReader.readLine()) != null) {
                List<String> puzzleDetails = List.of(numbers.split(" "));
                puzzle.add(puzzleDetails);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());

        }
        return puzzle;
    }
    public static void displaySudoku(List<List<String>> puzzle, String filename) {
        System.out.println(filename);
        System.out.println("+-------+-------+-------+");
        for (int i=0; i<puzzle.size(); i++){
            if(i!=0 && i%3 == 0){
                System.out.println("+-------+-------+-------+");
            }
            for (int j=0; j<puzzle.get(i).size(); j++){
                if(j%3==0){
                    System.out.print("| ");
                }
                System.out.print(puzzle.get(i).get(j)+" ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");

    }
    public static void displaySolvedSudoku(List<List<Integer>> puzzle, String filename) {
        System.out.println("solved: " + filename);
        System.out.println("+-------+-------+-------+");
        for (int i=0; i<puzzle.size(); i++){
            if(i!=0 && i%3 == 0){
                System.out.println("+-------+-------+-------+");
            }
            for (int j=0; j<puzzle.get(i).size(); j++){
                if(j%3==0){
                    System.out.print("| ");
                }
                System.out.print(puzzle.get(i).get(j)+" ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");

    }
    public static void saveSolvedSudoku(List<List<Integer>> puzzle, String filename) {
        String newFilename = filename + "-solution.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFilename))) {
            for (List<Integer> row : puzzle) {
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (Integer num : row) {
                    stringJoiner.add(num.toString());
                }
                bufferedWriter.write(stringJoiner.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {


        }
    }

}
