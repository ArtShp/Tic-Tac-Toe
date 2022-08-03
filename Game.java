package Lesson5.TicTacToe;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private Field field;

    private int drawCounter;

    private Scanner in;

    Game() {}

    public void startGame() {
        initGame();
        System.out.println("----------TIC-TAC-TOE GAME----------");
        System.out.println("Hi, players!");
        showRules();
        System.out.println("Good luck!");
        startGameLoop();
        showScore();
        System.out.println("\n----------GAME OVER----------");
    }

    private void initGame() {
        in = new Scanner(System.in);
        players = new Player[] {new Player(1), new Player(2)};
        field = new Field();
        drawCounter = 0;
    }

    private void showRules() {
        System.out.println("\nRules:");
        System.out.println("~To choose cell number enter digit from 1 to 9(excluding that was chosen)\n" +
                           " or just choose digit from the screen(from game field)");
        System.out.println("~Players swap each game. Player 1 starts the game, then player 2, and etc...");
        System.out.println("~To stop playing enter 'N' when you've been asked or any symbol not to finish");
        System.out.println("~Game score is shown after you finished playing");
        System.out.println();
    }

    private void showScore() {
        System.out.println("\n----------SCORE----------\n");
        System.out.printf("Player 1: %d\n", players[0].getWinsCounter());
        System.out.printf("Player 2: %d\n", players[1].getWinsCounter());
        System.out.printf("Draws: %d\n", drawCounter);
    }

    private void startGameLoop() {
        int gameCounter = 1;
        while (true) {
            System.out.printf("\n----------GAME %d----------\n", gameCounter);
            field.show();

            int playerIndex = (gameCounter-1) % 2; // player1 - 0, player2 - 1. Swap player each game

            while (true) {
                System.out.printf("Player %d choose: ", playerIndex+1);

                int cellNumber = in.nextInt();
                while (cellNumber < 1 || cellNumber > 9 || field.isCellMarked(cellNumber)) {
                    System.out.print("You've entered incorrect cell number! Try again: ");
                    cellNumber = in.nextInt();
                }

                field.markCell(players[playerIndex], cellNumber);
                field.show();

                if (field.checkFinish()) {
                    System.out.printf("Player %d has won!\n", playerIndex+1);
                    players[playerIndex].takeWinPoint();
                    break;
                }

                if (field.checkDraw()) {
                    System.out.println("Nobody has won!");
                    drawCounter++;
                    break;
                }

                playerIndex = (playerIndex == 0 ? 1 : 0); // Change player
            }

            System.out.print("Do you want to continue(y/N): ");
            if (in.next().equals("N")) {
                break;
            }

            field.clear();
            gameCounter++;
        }
    }
}
