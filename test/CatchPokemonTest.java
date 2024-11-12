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

    // Várias voltas na mesma área
    @Test
    public void testLargeGridWithLooping() {
        String moves = "NESONESONESONESO";
        assertEquals(4, CatchPokemon.countCapturedPokemons(moves));
    }

    @Test
    public void testLongPath() {
        assertEquals(4, CatchPokemon.countCapturedPokemons("NESO".repeat(1000)));
    }

    // Movimentos que visitam novas casas continuamente
    @Test
    public void testSpiralOutward() {
        String moves = "ENSSOONNEEESSOOONNNEEEE";
        assertEquals(17, CatchPokemon.countCapturedPokemons(moves));
    }

    @Test
    public void testLongStraightPath() {
        // Um caminho muito longo em linha reta para o norte
        assertEquals(10001, CatchPokemon.countCapturedPokemons("N".repeat(10000)));
    }

    // Movimenta-se em um quadrado de 10x10, alcançando os extremos e completa um loop
    @Test
    public void testLargeLoopSquarePath() {
        String moves =
                "N".repeat(10) +
                "E".repeat(10) +
                "S".repeat(10) +
                "O".repeat(10);
        assertEquals(40, CatchPokemon.countCapturedPokemons(moves));
    }

    // Movimentos em zigzag numa grande area
    @Test
    public void testComplexZigzagPath() {
        assertEquals(4, CatchPokemon.countCapturedPokemons("NESO".repeat(500)));
    }

    // Movimentos que se repetem para cima e para o lado (diagonal)
    @Test
    public void testDiagonalLikePath() {
        assertEquals(2001, CatchPokemon.countCapturedPokemons("NE".repeat(1000)));
    }

    // Movimentos em zigzag, mas com algumas voltas que resultam em caminhos repetidos
    @Test
    public void testZigzagWithBacktracking() {
        String moves = "NNESSSOOEENN";
        assertEquals(9, CatchPokemon.countCapturedPokemons(moves));
    }

    // Sequência longa com repetições que cobre um grande número de casas e repete outras
    @Test
    public void testRandomLongPathWithRepetitions() {
        String moves = "NESONNNOSEESEONONSOESSOENSONSEOSONES";
        assertEquals(15, CatchPokemon.countCapturedPokemons(moves));
    }

    // Apenas movimenta-se para Norte e Sul várias vezes
    @Test
    public void testPathWithOnlyTwoDirections() {
        String moves = "NSNSNSNSNSNSNSNSNSNS";
        assertEquals(2, CatchPokemon.countCapturedPokemons(moves));
    }
}
