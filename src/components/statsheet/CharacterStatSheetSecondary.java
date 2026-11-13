package components.statsheet;

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

        // Retrieve the character's current health
        int currentHealth = this.health();

        // Apply damage without allowing health to become negative
        if (damage >= currentHealth) {
            this.setHealth(0);
        } else {
            this.setHealth(currentHealth - damage);
        }
    }

    /**
     * Restores health without exceeding maximum health.
     *
     * @param amount
     *            the amount of health to restore
     * @requires amount >= 0
     * @ensures this.health = min(this.maxHealth, #this.health + amount)
     */
    @Override
    public void heal(int amount) {
        assert amount >= 0 : "Healing cannot be negative";

        // Calculate the amount of missing health
        int currentHealth = this.health();
        int maximumHealth = this.maxHealth();
        int missingHealth = maximumHealth - currentHealth;

        // Restore health without exceeding maximum health
        if (amount >= missingHealth) {
            this.setHealth(maximumHealth);
        } else {
            this.setHealth(currentHealth + amount);
        }
    }

    /**
     * Reports whether the character is alive.
     *
     * @return true if the character has health remaining
     * @ensures isAlive = (this.health > 0)
     */
    @Override
    public boolean isAlive() {
        // A character is alive when health is greater than 0
        return this.health() > 0;
    }

    /**
     * Reports how much health the character is missing.
     *
     * @return the amount of missing health
     * @ensures healthMissing = this.maxHealth - this.health
     */
    @Override
    public int healthMissing() {
        // Calculate the difference between maximum and current health
        return this.maxHealth() - this.health();
    }

    /**
     * Returns a string representation of the character statistics.
     *
     * @return the character statistics as a String
     */
    @Override
    public String toString() {
        // Build a readable representation using kernel getters
        String result = "Health: " + this.health() + "/" + this.maxHealth()
                + ", Attack: " + this.attack() + ", Defense: " + this.defense();

        return result;
    }

    /**
     * Checks whether this character has the same statistics as another.
     *
     * @param obj
     *            the object to compare
     * @return true if both objects have identical statistics
     */
    @Override
    public boolean equals(Object obj) {
        // Assume the objects aren't equal
        boolean result = false;

        // Check whether the object is a CharacterStatSheet
        if (obj instanceof CharacterStatSheet other) {
            // Compare all four stats using kernel methods
            result = this.health() == other.health()
                    && this.maxHealth() == other.maxHealth()
                    && this.attack() == other.attack()
                    && this.defense() == other.defense();
        }

        return result;
    }

    /**
     * Computes a hash code from the character's statistics.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        // Combine the four stats into a single hash code
        final int multiplier = 31;
        int result = 1;

        result = multiplier * result + this.health();
        result = multiplier * result + this.maxHealth();
        result = multiplier * result + this.attack();
        result = multiplier * result + this.defense();

        return result;
    }

}
