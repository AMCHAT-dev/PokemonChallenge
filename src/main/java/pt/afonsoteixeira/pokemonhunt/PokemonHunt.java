package pt.afonsoteixeira.pokemonhunt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PokemonHunt {
    public final static int MAX_MOVES = 50_000_000;
    int x = 0;
    int y = 0;

    public int huntPokemon(ArrayList<Move> moves) {
        Set<Long> visited = new HashSet<>();
        visited.add(houseKey(x, y));
        for (Move move : moves) {
            switch (move) {
                case N -> y++;
                case S -> y--;
                case E -> x++;
                case O -> x--;
            }
            visited.add(houseKey(x, y));
        }
        return visited.size();
    }

    private long houseKey(int x, int y) {
        return (long) MAX_MOVES * y + x;
    }
}
