package com.aleksandrmishin;

public class TextPrinter {

    private int delay = 900;

    public void greet() {
        String greeting = "\nДобро пожаловать в игру \"20 Спичек\"  \\ (•◡•) /\n \n" +
                "Правила:\n" +
                "На столе лежат 20 спичек.\n" +
                "Два игрока по очереди вытягивают от одной до трех спичек. \n" +
                "Тот, у кого останется последняя спичка - проиграл. \n";

        System.out.println(greeting);
    }

    public void declareTurn(Player player) throws InterruptedException {
        Thread.sleep(delay);
        System.out.println("\nИгрок " + player.getName() + ", Ваш ход.");
        Thread.sleep(delay);

        switch (Game.matchesLeft) {
            case (3):
                System.out.println("Вы можете вытянуть одну или две спички.");
                break;
            case (2):
                System.out.println("Вы можете вытянуть одну спичку.");
                break;
            default:
                System.out.println("Вы можете вытянуть одну, две или три спички.");
        }
        Thread.sleep(delay);
        System.out.println("Сколько спичек вы хотите вытянуть?");
    }

    public void declareWinner(Player player) throws InterruptedException {
        Thread.sleep(delay);
        System.out.println("\nИгра окончена.");
        System.out.println("Игрок " + player.getName() + " победил!");
    }

    public void declareLeftMatches() throws InterruptedException {
        Thread.sleep(delay);
        System.out.println("Осталось " + Game.matchesLeft);
    }

}
