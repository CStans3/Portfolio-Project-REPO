/**
 * Secondary implementation of the CharacterStatSheet component.
 *
 * Implements enhanced operations using only kernel methods.
 *
 * @author Connor Stanfield
 */
public abstract class CharacterStatSheetSecondary
        implements CharacterStatSheet {

    /**
     * Reduces current health without going below zero.
     *
     * @param damage
     *            the amount of damage taken
     * @requires damage >= 0
     * @ensures this.health = max(0, #this.health - damage)
     */
    @Override
    public void takeDamage(int damage) {
        assert damage >= 0 : "Damage cannot be negative";

        // Retrive the character's current health
        int currentHealth = this.health();

        // Apply damage without allowing health to become negative
        if (damage >= currentHealth) {
            this.setHealth(0);
        } else {
            this.setHealth(currentHealth - damage);
        }

    }

}
