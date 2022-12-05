import java.util.Scanner;

public class TicTacToe {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // welcome screen
        System.out.println("\nLet's play tic tac toe");
        char[][] board = {
                { '_', '_', '_' },
                { '_', '_', '_' },
                { '_', '_', '_' }
        };
        printBoard(board);

        // main program
        for (int i = 0; i < 9; i++) {  // 9 turns in total
            if (i % 2 == 0) {
                System.out.println("Turn: X");
                int[] selection = askUser(board);
                board[selection[0]][selection[1]] = 'X';
            } else {
                System.out.println("Turn: O");
                int[] selection = askUser(board);
                board[selection[0]][selection[1]] = 'O';
            }
            printBoard(board);
            int count = checkWin(board);
            if (count == 3) {
                System.out.println("X wins!");
                break;
            } else if (count == -3) {
                System.out.println("O wins!");
                break;
            } else if (i == 8) {
                System.out.println("it's a tie!");
            }
        }
        scan.close();
    }

    // print the current board to screen
    public static void printBoard(char[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            String temp = "\t";
            for (int j = 0; j < board[i].length; j++) {
                temp += (board[i][j] + " ");
            }
            System.out.println(temp);
        }
        System.out.print("\n");
    }

    // get the user's next move
    public static int[] askUser(char[][] board) {
        System.out.print(" * pick a row and column number: ");
        while (true) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            // check row and col is in valid range
            boolean inputValid = (row >= 0 && row < 3) && (col >= 0 && col < 3);
            if (!inputValid) {
                System.out.print(" * invalid spot, try another spot: ");
                continue;
            }
            // check if the spot is free on the board
            boolean spotFree = board[row][col] == '_';
            if (!spotFree) {
                System.out.print(" * that spot is taken, try another spot: ");
                continue;
            }
            int[] selection = { row, col };
            return selection;
        }
    }

    // check the board to see if anyone has won
    public static int checkWin(char[][] board) {
        int count = 0;

        // check rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                } else if (board[i][j] == 'O') {
                    count--;
                } else {
                    continue;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }

        // check columns
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'X') {
                    count++;
                } else if (board[j][i] == 'O') {
                    count--;
                } else {
                    continue;
                }
            }
            if (count == 3 || count == -3) {
                return count;
            } else {
                count = 0;
            }
        }

        // check left diag
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 'X') {
                count++;
            } else if (board[i][i] == 'O') {
                count--;
            }
            if (i == 2) { // last iteration
                if (count == 3 || count == -3) {
                    return count;
                } else {
                    count = 0;
                }
            }
        }

        // check right diag
        for (int i = 0; i < board.length; i++) {
            if (board[i][2 - i] == 'X') {
                count++;
            } else if (board[i][2 - i] == 'O') {
                count--;
            }
            if (i == 2) { // last iteration
                if (count == 3 || count == -3) {
                    return count;
                } else {
                    count = 0;
                }
            }
        }
        return count;
    }
}
