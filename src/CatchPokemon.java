import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CatchPokemon {
    public static void main(String[] args) {
        // Lê a sequência de movimentos da entrada padrão
        Scanner scanner = new Scanner(System.in);
        String moves = scanner.nextLine().trim();
        scanner.close();

        // Calcula o número de pokémons capturados
        int capturedPokemons = countCapturedPokemons(moves);
        System.out.println(capturedPokemons);
    }

    /**
     * Conta o número de pokémons capturados com base na sequência de movimentos.
     *
     * @param moves sequência de movimentos de Ash (N, S, E, O).
     * @return o número de pokémons capturados.
     */
    public static int countCapturedPokemons(String moves) {
        // Define a posição inicial do Ash
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        // Adiciona a posição inicial
        visited.add(x + "," + y);
        int pokemonsCaught = 1;

        // Itera sobre cada movimento
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'O': x--; break;
            }
            // Constrói a posição atual em formato string
            String position = x + "," + y;

            // Captura o pokémon se a posição for nova
            if (visited.add(position)) {
                pokemonsCaught++;
            }
        }

        return pokemonsCaught;
    }
}

