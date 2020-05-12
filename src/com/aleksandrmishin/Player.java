package com.aleksandrmishin;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
        this.name = "new player " + new Random().nextInt();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void makeTurn() {
        int playerPulled;
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            playerPulled = scanner.nextInt();
        } else {
            System.out.println("Пожалуйста, используйте только цифры.");
            makeTurn();
            return;
        }

        if (playerPulled > getNumberOfPossibleMoves(Game.matchesLeft) || playerPulled < 1) {
            System.out.println("Недопустимое число спичек. Выберите другое число.");
            makeTurn();
            return;
        }
        Game.matchesLeft -= playerPulled;
    }

    private int getNumberOfPossibleMoves(int matchesLeft) {
        return matchesLeft <= 3 ? matchesLeft - 1 : 3;
    }
}
