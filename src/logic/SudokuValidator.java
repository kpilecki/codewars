package logic;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(sudoku) + " Correct: true");

        sudoku[0][0]++;
        sudoku[1][1]++;
        sudoku[0][1]--;
        sudoku[1][0]--;

        System.out.println(check(sudoku) + " Correct: false");

        sudoku[0][0]--;
        sudoku[1][1]--;
        sudoku[0][1]++;
        sudoku[1][0]++;

        sudoku[4][4] = 0;

        System.out.println(check(sudoku) + " Correct: false");

    }

    public static boolean check(int[][] sudoku) {

        // Checks each row and column for duplicates
        for(int i = 0; i < sudoku.length; i++){
            Set<Integer> setRow = new HashSet<>();
            Set<Integer> setColumn = new HashSet<>();
            for(int j = 0; j < sudoku.length; j++) {
                if (!setRow.add(sudoku[i][j]) | !setColumn.add(sudoku[j][i])){
                    return false;
                }
            }
        }
        // Checks each 3 by 3 square for duplicates and for any zeroes
        for(int i = 0; i < sudoku.length; i += 3){
            for(int j = 0; j < sudoku.length; j += 3){
                Set<Integer> setSquare = new HashSet<>();
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        if(!setSquare.add(sudoku[k][l]) || sudoku[k][l] == 0){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}