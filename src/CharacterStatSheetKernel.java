
import components.standard.Standard;

/**
 * Kernel interface for an RPG character stat sheet.
 *
 * A character has current health, maximum health, attack, and defense
 * statistics.
 *
 * @mathmodel type CharacterStatSheetKernel is (health: integer, maxHealth:
 *            integer, attack: integer, defense: integer)
 * @initially <pre>
 *            this = (100, 100, 0, 0)
 *            </pre>
 * @invariant <pre>
 *            0 <= health <= maxHealth and
 *            maxHealth > 0 and
 *            attack >= 0 and defense >= 0
 *            </pre>
 */
public interface CharacterStatSheetKernel extends Standard<CharacterStatSheet> {

    /**
     * Reports the character's current health.
     *
     * @return the current health
     * @ensures health = this.health
     */
    int health();

    /**
     * Reports the character's maximum health.
     *
     * @return the maximum health
     * @ensures maxHealth = this.maxHealth
     */
    int maxHealth();

    /**
     * Reports the character's attack statistic.
     *
     * @return the attack statistic
     * @ensures attack = this.attack
     */
    int attack();

    /**
     * Reports the character's defense statistic.
     *
     * @return the defense statistic
     * @ensures defense = this.defense
     */
    int defense();

    /**
     * Updates the character's current health.
     *
     * @param health
     *            the new current health
     * @updates this
     * @requires 0 <= health and health <= this.maxHealth
     * @ensures <pre>
     *          this.health = health and
     *          this.maxHealth = #this.maxHealth and
     *          this.attack = #this.attack and
     *          this.defense = #this.defense
     *          </pre>
     */
    void setHealth(int health);

    /**
     * Updates maximum health and caps current health if necessary.
     *
     * @param maximum
     *            the new maximum health
     * @updates this
     * @requires maximum > 0
     * @ensures <pre>
     *          this.maxHealth = maximum and
     *          this.health = min(#this.health, maximum) and
     *          this.attack = #this.attack and
     *          this.defense = #this.defense
     *          </pre>
     */
    void setMaxHealth(int maximum);

    /**
     * Updates the character's attack statistic.
     *
     * @param attack
     *            the new attack statistic
     * @updates this
     * @requires attack >= 0
     * @ensures <pre>
     *          this.attack = attack and
     *          this.health = #this.health and
     *          this.maxHealth = #this.maxHealth and
     *          this.defense = #this.defense
     *          </pre>
     */
    void setAttack(int attack);

    /**
     * Updates the character's defense statistic.
     *
     * @param defense
     *            the new defense statistic
     * @updates this
     * @requires defense >= 0
     * @ensures <pre>
     *          this.defense = defense and
     *          this.health = #this.health and
     *          this.maxHealth = #this.maxHealth and
     *          this.attack = #this.attack
     *          </pre>
     */
    void setDefense(int defense);
}
