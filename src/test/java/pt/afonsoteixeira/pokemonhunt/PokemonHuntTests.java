package pt.afonsoteixeira.pokemonhunt;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class PokemonHuntTests {

    PokemonHunt program = new PokemonHunt();

    @Test
    public void PokemonHuntValidCaseTest1() {
        // given
        String moves = "E";

        // expect
        assertEquals(2, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntValidCaseTest2() {
        // given
        String moves = "NESO";

        // expect
        assertEquals(4, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntValidCaseTest3() {
        // given
        String moves = "NSNSNSNSNS";

        // expect
        assertEquals(2, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntValidCaseTest4() {
        // given
        String moves = "SOSOSOSOSOSOSOSOSOSOSOSOSOSOSOOSOSOSOSOS";

        // expect
        assertEquals(moves.length() + 1, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntExtremelyLargeInputTest() {
        // given
        int capacity = PokemonHunt.MAX_MOVES;
        String moves = "S".repeat(capacity);

        // expect
        assertEquals(capacity + 1, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntLargeRandomInputTest() {
        // given
        int capacity = PokemonHunt.MAX_MOVES / 10;
        Random rand = new Random();
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            int randomNum = rand.nextInt(Move.values().length);
            switch (randomNum) {
                case 0 -> moves.add(Move.N);
                case 1 -> moves.add(Move.S);
                case 2 -> moves.add(Move.E);
                case 3 -> moves.add(Move.O);
            }
        }
        // expect
        // this is working
        program.huntPokemon(moves);
    }

    @Test
    public void PokemonHuntLargeRandomInputTest2() {
        // given
        int capacity = PokemonHunt.MAX_MOVES / 10;
        Random rand = new Random();
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            int randomNum = rand.nextInt(2);
            switch (randomNum) {
                case 0 -> moves.add(Move.S);
                case 1 -> moves.add(Move.O);
            }
        }

        // expect
        assertEquals(capacity + 1, program.huntPokemon(moves));
    }

    @Test
    public void PokemonHuntIncorrectInputTest1() {
        // given
        String moves = "n0s1eo ABC";

        // expect
        assertEquals(1, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }

    @Test
    public void PokemonHuntIncorrectInputTest2() {
        // given
        String moves = "N S";

        // expect
        assertEquals(2, program.huntPokemon(Move.convertToArrayListOfMoves(moves)));
    }
}
