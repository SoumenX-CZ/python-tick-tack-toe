import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char[][] board = {
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY}
    };

    public static void main(String[] args) {
        char currentPlayer = PLAYER_X;
        boolean gameRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            printBoard();
            System.out.println("Hráč " + currentPlayer + ", zadejte řádek (0-2):");
            int row = scanner.nextInt();
            System.out.println("Hráč " + currentPlayer + ", zadejte sloupec (0-2):");
            int col = scanner.nextInt();

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != EMPTY) {
                System.out.println("Neplatný tah, zkuste to znovu.");
                continue;
            }

            board[row][col] = currentPlayer;
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Hráč " + currentPlayer + " vyhrál!");
                gameRunning = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("Remíza!");
                gameRunning = false;
            } else {
                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}