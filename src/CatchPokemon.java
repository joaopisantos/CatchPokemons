import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CatchPokemon {
    public static void main(String[] args) {
        String moves;
        if (args.length > 0) {
            moves = args[0];  // Usa o primeiro argumento que é passado (Program Arguments)
        } else {
            // Fallback para a leitura do stdin se nenhum argumento for passado
            Scanner scanner = new Scanner(System.in);
            moves = scanner.nextLine().trim();
            scanner.close();
        }

        // Calcula o número de pokémons capturados
        int capturedPokemons = countCapturedPokemons(moves);
        System.out.println(capturedPokemons);
    }

    /**
     * Conta o número de pokémons capturados com base na sequência de movimentos.
     *
     * @param moves sequência de movimentos do Ash (N, S, E, O).
     * @return o número de pokémons capturados.
     */
    public static int countCapturedPokemons(String moves) {
        // Posição inicial do Ash
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        // Adiciona a posição inicial
        visited.add(x + "," + y);
        int pokemonsCaught = 1;

        // Itera cada movimento
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'O': x--; break;
                default: throw new IllegalArgumentException("Movimento inválido: " + move);
            }
            // Constrói a posição atual
            String position = x + "," + y;

            // Captura o pokémon se a posição for nova
            if (visited.add(position)) {
                pokemonsCaught++;
            }
        }

        return pokemonsCaught;
    }
}

