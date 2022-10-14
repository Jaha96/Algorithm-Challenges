import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args){

        ValidSudoku sudoku = new ValidSudoku();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'}, 
            {'6','.','.','1','9','5','.','.','.'}, 
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'}, 
            {'4','.','.','8','.','3','.','.','1'}, 
            {'7','.','.','.','2','.','.','.','6'}, 
            {'.','6','.','.','.','.','2','8','.'}, 
            {'.','.','.','4','1','9','.','.','5'}, 
            {'.','.','.','.','8','.','.','7','9'}};
        
        System.out.println(sudoku.isValidSudoku(board));


        char[][] board2 = {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}};
        
        System.out.println(sudoku.isValidSudoku(board2));
    }


    // 2022.10.13 Run through rows and cols, !important Need to check 3x3 blocks
    // 2022.10.14 Solved 3x3 block
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character> row;
        Set<Character> col;
        Set<Character> block;

        for(int r=0; r<board.length; r++){
            row = new HashSet<>();
            col = new HashSet<>();
            block = new HashSet<>();
            for(int c=0; c<board[r].length; c++){
                char rowNumber = board[r][c];
                if(rowNumber != '.' && !row.add(rowNumber)) return false;

                char colNumber = board[c][r];
                if(colNumber != '.' && !col.add(colNumber)) return false;

                

                // char blockNumber = board[c/3 + (r/3)*3][c%3 + (r/3)*3];
                char blockNumber = board[3*(r/3) + c/3][3*(r%3) + c%3];
                if(blockNumber != '.' && !block.add(blockNumber)) return false;
            }
        }
        
        
        return true;
    }
}
