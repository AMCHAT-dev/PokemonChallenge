package pt.afonsoteixeira.pokemonhunt;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Move {
    E,
    O,
    N,
    S;

    public static ArrayList<Move> convertToArrayListOfMoves(String moves) {
        return moves.chars()
                .mapToObj(c -> parseMove((char) c))
                .flatMap(Optional::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static Optional<Move> parseMove(char move) {
        try {
            return Optional.of(Move.valueOf(String.valueOf(move)));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

}
