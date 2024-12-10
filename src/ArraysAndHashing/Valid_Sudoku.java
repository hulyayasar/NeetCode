package ArraysAndHashing;

import java.util.*;

public class Valid_Sudoku {

    public static boolean isValidSudoku_3(char[][] board) {

        //check each value in rows
        for(int i = 0; i<9; i++){
            for(int k = 0; k<9; k++){
                Set<Character> set_r = new HashSet<Character>();
                if(board[i][k] =='.'){
                    continue;
                }else {
                    if(set_r.contains(board[i][k])){
                        return false;
                    }else{
                        set_r.add(board[i][k]);
                    }
                }
                System.out.println("set_r " + set_r);  //
            }

            //check each value in column
            for(int k = 0; k<9; k++){
                Set<Character> set_c = new HashSet<Character>();
                if(board[k][i] =='.'){
                    continue;
                }else {

                    if(set_c.contains(board[k][i])){
                        return false;
                    }else{
                        set_c.add(board[k][i]);
                    }
                }
                System.out.println("set_c " + set_c);
            }

            //check each 3,3 grids
            Set<Character> set_b = new HashSet<Character>();
            if((i+1) % 3 == 0){
                for(int x=i-2; x<=i; x++){
                    for(int y=i-2; y<=i; y++){
                        if(board[x][y] =='.'){
                            continue;
                        }else {

                            if(set_b.contains(board[x][y])){
                                return false;
                            }else{
                                set_b.add(board[x][y]);
                            }
                        }

                    }

                }
            }
            System.out.println("set_b " + set_b);
        }
        return true;

    }

    //Bitmask
    public static boolean isValidSudoku_4(char[][] board) {


        for(int r= 0; r<9; r++){
            int [] row = new int[9];
            int[] column = new int[9];
            int[] block = new int[9];

            for(int c= 0; c<9; c++){

                int currentValue = board[r][c]-1;

                if( ((row[r] & (1<<currentValue)) > 0) ||
                        ((column[c] & (1<<currentValue))> 0) ||
                        ((block[((r/3)*3 + (c/3))] & (1<<currentValue)) > 0))
                    return false;
                else{
                    row[r] = row[r] | (1<<currentValue);
                    column[c] = column[c] | (1<<currentValue);
                    block[((r/3)*3 + (c/3))] |= (1<<currentValue);

                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

        char[][] board = {{'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku_4(board));

    }

    public boolean isValidSudoku(char[][] board) {

        //boolean flag = true;

        for(int i = 0; i<9; i++){
            for(int k = 0; k<9; k++){

                //check row and column for each point
                for(int l=0; l<k; l++){

                    if((board[i][l] == board[i][k]) && (board[i][l]!='.' && board[i][k]!='.')){
                        System.out.println(" i and k " + i +" " + k) ;
                        return false;
                    }
                    if((board[l][i] == board[k][i])&& (board[l][i]!='.' && board[k][i]!='.')){
                        System.out.println("col i and k " + i +" " + k) ;
                        return false;
                    }
                }
            }

            // check [3,3] boxes



        }
        return true;

    }
    public boolean isValidSudoku_2(char[][] board) {

        //boolean flag = true;

        for(int i = 0; i<9; i++){
            for(int k = 0; k<9; k++){

                //create list for each row
                List<Character> list = new ArrayList<Character>();
                for (char c: board[i]) {
                    if(c != '.')
                        list.add(c);
                }
                Set<Character> set = new HashSet<Character>(list);
                if(!list.equals(set)) {
                    return false;
                }

            }

            // check [3,3] boxes

        }
        return true;

    }


}
