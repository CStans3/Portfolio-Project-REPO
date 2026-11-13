package components.statsheet;

/**
 * Enhanced interface for an RPG character stat sheet.
 *
 * Provides operations for taking damage, healing, and checking the character's
 * health status.
 *
 * @author Connor Stanfield
 */
public interface CharacterStatSheet extends CharacterStatSheetKernel {

    /**
     * Reduces current health without going below zero.
     *
     * @param damage
     *            the amount of damage taken
     * @updates this
     * @requires damage >= 0
     * @ensures <pre>
     *          this.health = max(0, #this.health - damage) and
     *          this.maxHealth = #this.maxHealth and
     *          this.attack = #this.attack and
     *          this.defense = #this.defense
     *          </pre>
     */
    void takeDamage(int damage);

    /**
     * Restores health without exceeding maximum health.
     *
     * @param amount
     *            the amount of health to restore
     * @updates this
     * @requires amount >= 0
     * @ensures <pre>
     *          this.health =
     *              min(this.maxHealth, #this.health + amount) and
     *          this.maxHealth = #this.maxHealth and
     *          this.attack = #this.attack and
     *          this.defense = #this.defense
     *          </pre>
     */
    void heal(int amount);

    /**
     * Reports whether the character is alive.
     *
     * @return true if current health is greater than zero
     * @ensures isAlive = (this.health > 0)
     */
    boolean isAlive();

    /**
     * Reports the amount of missing health.
     *
     * @return the amount of missing health
     * @ensures healthMissing = this.maxHealth - this.health
     */
    int healthMissing();
}
