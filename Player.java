package Lesson5.TicTacToe;

class Player {
    private char symbol;
    private int winsCounter;

    Player(int n) {
        symbol = (n == 1 ? 'X' : 'O');
        winsCounter = 0;
    }

    char getSymbol() {
        return symbol;
    }

    int getWinsCounter() {
        return winsCounter;
    }

    void takeWinPoint() {
        winsCounter++;
    }
}
