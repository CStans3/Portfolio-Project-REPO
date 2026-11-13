package components.statsheet;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

/**
 * Abstract JUnit test class for CharacterStatSheet.
 */
public abstract class CharacterStatSheetTest {

    /**
     * Default max health.
     */
    private static final int DEFAULT_HEALTH = 100;

    /**
     * Test max health.
     */
    private static final int MAX_HEALTH = 150;

    /**
     * Test attack stat.
     */
    private static final int ATTACK = 30;

    /**
     * Test defense stat.
     */
    private static final int DEFENSE = 20;

    /**
     * Creates a new character with default statistics.
     *
     * @return a default character stat sheet
     */
    protected abstract CharacterStatSheet constructorTest();

    /**
     * Creates a new character with the given statistics.
     *
     * @param maxHealth
     *            max health
     * @param attack
     *            attack stat
     * @param defense
     *            defense stat
     * @return a character with the given stats
     */
    protected abstract CharacterStatSheet constructorTest(int maxHealth,
            int attack, int defense);

}
