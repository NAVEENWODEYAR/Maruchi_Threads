package com.backTracking;

/**
 * @author NaveenWodeyar
 * @date 18-Jul-2025
 * Place N queens on an N×N chessBoard so that no two queens threaten each other.
 */

public class NQueens {
    final int N = 16;

    void printSolution(int board[][]) {
        for (int[] row : board) {
            for (int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;

        for (int i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1) return false;

        for (int i=row, j=col; i<N && j>=0; i++, j--)
            if (board[i][j] == 1) return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N) return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0; // BACKTRACK
            }
        }

        return false;
    }

    void solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    public static void main(String args[]) {
        new NQueens().solveNQ();
    }
}
