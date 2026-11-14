package components.statsheet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

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

    /**
     * Tests changing attack.
     */
    @Test
    public void testSetAttack() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Update attack
        character.setAttack(ATTACK);

        // Verify attack changed
        assertEquals(ATTACK, character.attack());
        assertEquals(0, character.defense());
    }

    /**
     * Tests changing defense.
     */
    @Test
    public void testSetDefense() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Update defense
        character.setDefense(DEFENSE);

        // Verify defense changed
        assertEquals(DEFENSE, character.defense());
        assertEquals(0, character.attack());
    }

    /**
     * Tests normal damage.
     */
    @Test
    public void testTakeDamageNormal() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Apply damage
        character.takeDamage(DAMAGE);

        // Verify the remaining health
        assertEquals(DEFAULT_HEALTH - DAMAGE, character.health());
        assertTrue(character.isAlive());
    }

    /**
     * Tests damage equal to current health.
     */
    @Test
    public void testTakeDamageExact() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Reduce health to zero
        character.takeDamage(DEFAULT_HEALTH);

        // Verify the character is defeated
        assertEquals(0, character.health());
        assertFalse(character.isAlive());
    }

    /**
     * Tests damage greater than current health.
     */
    @Test
    public void testTakeExcessive() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Apply more damage than the character has health
        character.takeDamage(MAX_HEALTH);

        // Verify health does not become negative
        assertEquals(0, character.health());
    }

    /**
     * Tests taking zero damage.
     */
    @Test
    public void testTakeDamageZero() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Apply zero damage
        character.takeDamage(0);

        // Verify health remains unchanged
        assertEquals(DEFAULT_HEALTH, character.health());
    }

    /**
     * Tests normal healing.
     */
    @Test
    public void testHealNormal() {
        // Create a character with reduced health
        CharacterStatSheet character = new CharacterStatSheet1L();
        character.setHealth(TEST_HEALTH);

        // Restore some health
        character.heal(HEALING);

        // Verify the restored health
        assertEquals(TEST_HEALTH + HEALING, character.health());
    }

    /**
     * Tests healing beyond maximum health.
     */
    @Test
    public void testHealExcessive() {
        // Create a character with reduced health
        CharacterStatSheet character = new CharacterStatSheet1L();
        character.setHealth(TEST_HEALTH);

        // Attempt to heal beyond maximum health
        character.heal(MAX_HEALTH);

        // Verify health is capped at the maximum
        assertEquals(DEFAULT_HEALTH, character.health());
    }

    /**
     * Tests healing when already at maximum health.
     */
    @Test
    public void testHealAtMaximum() {
        // Create a default character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Attempt to heal at full health
        character.heal(HEALING);

        // Verify that health remains unchanged
        assertEquals(DEFAULT_HEALTH, character.health());
    }

    /**
     * Tests healing by zero.
     */
    @Test
    public void testHealZero() {
        // Creata a character with reduced health
        CharacterStatSheet character = new CharacterStatSheet1L();
        character.setHealth(TEST_HEALTH);

        // Apply zero healing
        character.heal(0);

        // Verify health remains unchanged
        assertEquals(TEST_HEALTH, character.health());
    }

    /**
     * Tests missing health.
     */
    @Test
    public void testHealthMissing() {
        // new character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Apply damage
        character.takeDamage(DAMAGE);

        // Verify the amount of missing health
        assertEquals(DAMAGE, character.healthMissing());
    }

    /**
     * Tests missing health when at full.
     */
    @Test
    public void testHealthMissingFull() {
        // new character
        CharacterStatSheet character = new CharacterStatSheet1L();

        // Verify no health is missing
        assertEquals(0, character.healthMissing());
    }

    /**
     * Tests resetting a modified character.
     */
    @Test
    public void testClear() {
        // Creat a custom stat character
        CharacterStatSheet character = new CharacterStatSheet1L(MAX_HEALTH,
                ATTACK, DEFENSE);

        // Modify the character before clearing
        character.takeDamage(DAMAGE);
        character.clear();

        // Verify all stats got reset
        assertEquals(DEFAULT_HEALTH, character.health());
        assertEquals(DEFAULT_HEALTH, character.maxHealth());
        assertEquals(0, character.attack());
        assertEquals(0, character.defense());
    }

    /**
     * Tests creating a new instance.
     */
    @Test
    public void testNewInstance() {
        // New character with custom stats
        CharacterStatSheet character = new CharacterStatSheet1L(MAX_HEALTH,
                ATTACK, DEFENSE);

        // Create a new instance
        CharacterStatSheet result = character.newInstance();

        // Verify the new instance has default stats
        assertEquals(DEFAULT_HEALTH, result.health());
        assertEquals(DEFAULT_HEALTH, result.maxHealth());
        assertEquals(0, result.attack());
        assertEquals(0, result.defense());

        // Verify the objects are distinct
        assertNotSame(character, result);

        // Verify the original character wasn't changed
        assertEquals(MAX_HEALTH, character.health());
        assertEquals(ATTACK, character.attack());
        assertEquals(DEFENSE, character.defense());
    }

    /**
     * Tests transferring statistics between characters.
     */
    @Test
    public void testTransferFrom() {
        // new source and destination characters
        CharacterStatSheet source = new CharacterStatSheet1L(MAX_HEALTH, ATTACK,
                DEFENSE);
        CharacterStatSheet destination = new CharacterStatSheet1L();

        // Modify the source and transfer its stats
        source.takeDamage(DAMAGE);
        destination.transferFrom(source);

        // Verify the destination received the source values
        assertEquals(MAX_HEALTH - DAMAGE, destination.health());
        assertEquals(MAX_HEALTH, destination.maxHealth());
        assertEquals(ATTACK, destination.attack());
        assertEquals(DEFENSE, destination.defense());

        // Verify the source returned to its initial value
        assertEquals(DEFAULT_HEALTH, source.health());
        assertEquals(DEFAULT_HEALTH, source.maxHealth());
        assertEquals(0, source.attack());
        assertEquals(0, source.defense());
    }

    /**
     * Tests equality and hash codes.
     */
    @Test
    public void testEqualsAndHashCode() {
        // Create two characters with identical stats
        CharacterStatSheet first = new CharacterStatSheet1L(MAX_HEALTH, ATTACK,
                DEFENSE);
        CharacterStatSheet second = new CharacterStatSheet1L(MAX_HEALTH, ATTACK,
                DEFENSE);

        // Verify equality and matching hash codes
        assertTrue(first.equals(second));
        assertEquals(first.hashCode(), second.hashCode());

        // Change one character and verify they're unequal
        second.takeDamage(DAMAGE);
        assertFalse(first.equals(second));
    }

}
