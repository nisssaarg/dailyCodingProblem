/*
 * You have an N by N board. Write a function that, given N, 
 * returns the number of possible arrangements of the board 
 * where N queens can be placed on the board without threatening each other, 
 * i.e. no two queens share the same row, column, or diagonal.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	
	public static void main(String[] args) {
		
		List<List<String>> result= solveNQueens(5);
		for(List<String> i: result) {
			for(String j:i) {
				System.out.print(j+",");
			}
			System.out.println();
		}
	}
	
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private static void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private static boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
