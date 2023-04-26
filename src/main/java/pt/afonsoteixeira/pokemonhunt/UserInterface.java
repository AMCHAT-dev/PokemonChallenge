package pt.afonsoteixeira.pokemonhunt;

import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    private void showMenu() {
        String formattedNumber = String.format("%d", PokemonHunt.MAX_MOVES);
        System.out.println("\nApenas as letras \"N\" \"S\" \"O\" \"E\" serao consideradas " +
                "todas as outras incluindo letras minusculas serao ignoradas \nInserir movimentos " +
                "na linha abaixo (A sequencia mais longa possivel e de " + formattedNumber + "): ");
    }
    public ArrayList<Move> presentMenuAndReadMoves() {
        String readedMoves;
        do {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            readedMoves = scanner.nextLine();
        } while (readedMoves.length() > PokemonHunt.MAX_MOVES);

        return Move.convertToArrayListOfMoves(readedMoves);
    }

    public int countHuntedPokemon(ArrayList<Move> moves) {
        PokemonHunt pokemonHunt = new PokemonHunt();
        return pokemonHunt.huntPokemon(moves);
    }

    public void showNumberOfHuntedPokemon(int huntedPokemon) {
        System.out.println("O numero de pokemon cacados foi: " + huntedPokemon);
    }
}
