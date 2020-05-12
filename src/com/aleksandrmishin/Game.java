package com.aleksandrmishin;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static int matchesLeft = 20;

    private Player firstPlayer;
    private Player secondPlayer;

    private TextPrinter textPrinter = new TextPrinter();

    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.playGame();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("\nВозникла исключительная ситуация. Обратитесь к разработчкику.");
        }
    }

    public void playGame() throws InterruptedException {
        textPrinter.greet();
        initializePlayers();

        Player activePlayer = !(secondPlayer instanceof Maitre) && new Random().nextBoolean() ? firstPlayer : secondPlayer;

        while (matchesLeft != 1) {
            textPrinter.declareTurn(activePlayer);
            activePlayer.makeTurn();
            textPrinter.declareLeftMatches();
            activePlayer = activePlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
        }
        textPrinter.declareWinner(activePlayer.equals(firstPlayer) ? secondPlayer : firstPlayer);
    }

    private void initializePlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, представьтесь:");
        this.firstPlayer = new Player(scanner.nextLine());

        System.out.println("Введите имя второго игрока (если вы желаете сразиться с Мэтром Теней, просто нажмите Enter)");
        String secondPlayerName = scanner.nextLine();
        this.secondPlayer = secondPlayerName.isEmpty() ? new Maitre() : new Player(secondPlayerName);
    }
}
