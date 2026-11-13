package components.statsheet;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotSame;
//import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for CharacterStatSheet1L.
 */
public class CharacterStatSheet1LTest {

    /**
     * Default maximum health.
     */
    private static final int DEFAULT_HEALTH = 100;

    /**
     * Custom maximum health.
     */
    private static final int MAX_HEALTH = 150;

    /**
     * Custom attack statistic.
     */
    private static final int ATTACK = 30;

    /**
     * Custom defense statistic.
     */
    private static final int DEFENSE = 20;

    /**
     * Health value used in tests.
     */
    private static final int TEST_HEALTH = 50;

    /**
     * Damage value used in tests.
     */
    private static final int DAMAGE = 25;

    /**
     * Healing value used in tests.
     */
    private static final int HEALING = 20;

    /**
     * Tests the default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        // Create a character with default statistics
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Verify the default statistics
        assertEquals(DEFAULT_HEALTH, character.health());
        assertEquals(DEFAULT_HEALTH, character.maxHealth());
        assertEquals(0, character.attack());
        assertEquals(0, character.defense());
    }

    /**
     * Tests the constructor with custom statistics.
     */
    @Test
    public void testParameterizedConstructor() {
        // Create a character with custom statistics
        CharacterStatSheet character = new CharacterStatSheet1L(MAX_HEALTH,
                ATTACK, DEFENSE);

        // Verify the starting statistics
        assertEquals(MAX_HEALTH, character.health());
        assertEquals(MAX_HEALTH, character.maxHealth());
        assertEquals(ATTACK, character.attack());
        assertEquals(DEFENSE, character.defense());
    }

    /**
     * Tests changing current health.
     */
    @Test
    public void testSetHealth() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Update current health
        character.setHealth(TEST_HEALTH);

        // Verify the updated and unchanged values
        assertEquals(TEST_HEALTH, character.health());
        assertEquals(DEFAULT_HEALTH, character.maxHealth());
        assertEquals(0, character.attack());
        assertEquals(0, character.defense());
    }

    /**
     * Tests reducing maximum health below current health.
     */
    @Test
    public void testSetMaxHealthDecrease() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Reduce max health
        character.setMaxHealth(TEST_HEALTH);

        // Current health should also be reduced
        assertEquals(TEST_HEALTH, character.health());
        assertEquals(TEST_HEALTH, character.maxHealth());
    }

    /**
     * Tests increasing max health.
     */
    @Test
    public void testSetMaxHealthIncrease() {
        // Create a character with reduced health
        CharacterStatSheet character = new CharacterStatSheet1L();
        character.setHealth(TEST_HEALTH);

        // Increase max hp
        character.setMaxHealth(MAX_HEALTH);

        // Current health should remain unchanged
        assertEquals(TEST_HEALTH, character.health());
        assertEquals(MAX_HEALTH, character.maxHealth());
    }

}
