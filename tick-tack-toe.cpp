#include <iostream>

const int SIZE = 3;
char board[SIZE][SIZE] = { {'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'} };

void drawBoard() {
    std::cout << "Tic-Tac-Toe\n";
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            std::cout << board[i][j] << " ";
        }
        std::cout << "\n";
    }
}

bool checkWin(char player) {
    for (int i = 0; i < SIZE; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
    }
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
    return false;
}

void makeMove(char player) {
    int move;
    std::cout << "Hráč " << player << ", zadej číslo pole: ";
    std::cin >> move;

    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (board[i][j] == ('0' + move)) {
                board[i][j] = player;
                return;
            }
        }
    }
    std::cout << "Neplatný tah, zkuste to znovu.\n";
    makeMove(player);
}

int main() {
    char currentPlayer = 'X';
    int moves = 0;

    while (moves < SIZE * SIZE) {
        drawBoard();
        makeMove(currentPlayer);
        moves++;

        if (checkWin(currentPlayer)) {
            drawBoard();
            std::cout << "Hráč " << currentPlayer << " vyhrál!\n";
            break;
        }

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    if (moves == SIZE * SIZE) {
        std::cout << "Remíza!\n";
    }

    return 0;
}