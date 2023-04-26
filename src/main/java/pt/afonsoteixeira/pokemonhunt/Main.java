package pt.afonsoteixeira.pokemonhunt;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        UserInterface user = new UserInterface();

        ArrayList<Move> moves = user.presentMenuAndReadMoves();
        int huntedPokemon = user.countHuntedPokemon(moves);
        user.showNumberOfHuntedPokemon(huntedPokemon);

    }

}