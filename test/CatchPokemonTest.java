import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CatchPokemonTest {

    @Test
    public void testSingleMoveEast() {
        assertEquals(2, CatchPokemon.countCapturedPokemons("E"));
    }

    @Test
    public void testAllDirections() {
        assertEquals(4, CatchPokemon.countCapturedPokemons("NESO"));
    }

    @Test
    public void testRepeatedMoves() {
        assertEquals(2, CatchPokemon.countCapturedPokemons("NSNSNSNSNS"));
    }

    @Test
    public void testNoMove() {
        assertEquals(1, CatchPokemon.countCapturedPokemons(""));
    }

    @Test
    public void testLargeGridWithLooping() {
        String moves = "NESONESONESONESO"; // Testando várias voltas na mesma área
        assertEquals(4, CatchPokemon.countCapturedPokemons(moves));
    }

    @Test
    public void testLongPath() {
        StringBuilder moves = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            moves.append("NESO");
        }
        assertEquals(4, CatchPokemon.countCapturedPokemons(moves.toString()));
    }
}
