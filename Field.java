package Lesson5.TicTacToe;

class Field {
    private final char[][] field;

    Field() {
        field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = (char)(j+i*3+'1');
            }
        }
    }

    void show() {
        System.out.println();
        for (char[] chars : field) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void markCell(Player player, int cellNumber) {
        field[(cellNumber-1) / 3][(cellNumber-1) % 3] = player.getSymbol();
    }

    boolean isCellMarked(int cellNumber) {
        switch (field[(cellNumber-1) / 3][(cellNumber-1) % 3]) {
            case 'X':
            case 'O':
                return true;
            default:
                return false;
        }
    }

    boolean checkFinish() {
        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i]) {return true;}
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2]) {return true;}
        }
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2]) {return true;}
        if (field[0][2] == field[1][1] && field[0][2] == field[2][0]) {return true;}

        return false;
    }

    boolean checkDraw() {
        for (char[] chars : field) {
            for (char c : chars) {
                if (c != 'X' && c != 'O') {return false;}
            }
        }
        return true;
    }

    void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = (char)(j+i*3+'1');
            }
        }
    }
}
