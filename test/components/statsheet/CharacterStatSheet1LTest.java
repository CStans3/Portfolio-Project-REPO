
package components.statsheet;

/**
 * JUnit tests for CharacterStatSheet1L.
 */
public class CharacterStatSheet1LTest extends CharacterStatSheetTest {

    /**
     * Creates a default CharacterStatSheet1L for testing.
     *
     * @return a default character stat sheet
     */
    @Override
    protected CharacterStatSheet constructorTest() {
        return new CharacterStatSheet1L();
    }

    /**
     * Creates a CharacterStatSheet1L with the given statistics.
     *
     * @param maxHealth
     *            maximum health
     * @param attack
     *            attack statistic
     * @param defense
     *            defense statistic
     * @return a character with the given statistics
     */
    @Override
    protected CharacterStatSheet constructorTest(int maxHealth, int attack,
            int defense) {
        return new CharacterStatSheet1L(maxHealth, attack, defense);
    }
}
