package com.aleksandrmishin;

public final class Maitre extends Player {

    private final String NAME = "Мэтр Теней ( ͡ʘ ͜ʖ ͡ʘ)";

    public Maitre() {
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void makeTurn() {
        int winNumber = 17;
        int matchesLeft = Game.matchesLeft;

        while (winNumber >= matchesLeft) {
            winNumber -= 4;
        }

        int maitrePulled = (matchesLeft - winNumber) > 3 ? 1 : matchesLeft - winNumber;
        System.out.println(NAME + " вытянул " + maitrePulled);
        Game.matchesLeft -= maitrePulled;
    }
}
