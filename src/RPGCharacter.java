import components.statsheet.CharacterStatSheet;
import components.statsheet.CharacterStatSheet1L;

/**
 * Example of using CharacterStatSheet inside another class.
 *
 * @author Connor Stanfield
 */
public class RPGCharacter {

    /**
     * The character's stats.
     */
    private CharacterStatSheet stats;

    /**
     * Creates an RPG character with the given statistics.
     *
     * @param health
     *            the character's max hp
     * @param attack
     *            the character's atk
     * @param defense
     *            the character's def
     */
    public RPGCharacter(int health, int attack, int defense) {
        // Initialize the character's stat sheet
        this.stats = new CharacterStatSheet1L(health, attack, defense);
    }

    /**
     * Applies damage to the character.
     *
     * @param damage
     *            the amount of damage taken
     */
    public void takeDamage(int damage) {
        // Use the component to reduce the character's helath
        this.stats.takeDamage(damage);
    }

}
