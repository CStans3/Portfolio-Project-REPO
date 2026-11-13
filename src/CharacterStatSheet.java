
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof-of-concept for an RPG style character stat sheet. Tracks health,
 * attack, and defense statistics.
 *
 * @author Connor Stanfield
 */
public class CharacterStatSheet {

    /*
     * Constants used to initialize and modify character statistics
     */

    /**
     * Starting maximum health for the demonstration.
     */
    private static final int STARTING_HEALTH = 100;

    /**
     * Starting attack for the demonstration.
     */
    private static final int STARTING_ATTACK = 20;

    /**
     * Starting defense for the demonstration.
     */
    private static final int STARTING_DEFENSE = 10;

    /**
     * Damage applied during the demonstration.
     */
    private static final int DAMAGE_AMOUNT = 25;

    /**
     * Healing applied during the demonstration.
     */
    private static final int HEAL_AMOUNT = 20;

    /**
     * Amount added when upgrading a statistic.
     */
    private static final int UPGRADE_AMOUNT = 5;

    /*
     * Representation fields that store the character's statistics
     */

    /**
     * Character's current health.
     */
    private int health;

    /**
     * Character's maximum health.
     */
    private int maxHealth;

    /**
     * Character's attack statistic.
     */
    private int attack;

    /**
     * Character's defense statistic.
     */
    private int defense;

    /**
     * Creates a character with the given statistics.
     *
     * @param maxHealth
     *            the maximum health
     * @param attack
     *            the starting attack
     * @param defense
     *            the starting defense
     * @requires maxHealth > 0 and attack >= 0 and defense >= 0
     * @ensures this.health = maxHealth and this.maxHealth = maxHealth and
     *          this.attack = attack and this.defense = defense
     */
    public CharacterStatSheet(int maxHealth, int attack, int defense) {
        // Verify that the starting statistics are valid
        assert maxHealth > 0 : "Maximum health must be positive";
        assert attack >= 0 : "Attack cannot be negative";
        assert defense >= 0 : "Defense cannot be negative";

        // Initialize the character's starting statistics
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Reports the current health.
     *
     * @return the current health
     */
    public int health() {
        return this.health;
    }

    /**
     * Reports the maximum health.
     *
     * @return the maximum health
     */
    public int maxHealth() {
        return this.maxHealth;
    }

    /**
     * Reports the attack statistic.
     *
     * @return the attack statistic
     */
    public int attack() {
        return this.attack;
    }

    /**
     * Reports the defense statistic.
     *
     * @return the defense statistic
     */
    public int defense() {
        return this.defense;
    }

    /**
     * Updates the current health.
     *
     * @param health
     *            the new current health
     * @requires 0 <= health and health <= this.maxHealth
     * @ensures this.health = health
     */
    public void setHealth(int health) {
        assert health >= 0
                && health <= this.maxHealth : "Health must be within the allowed range";

        // Update the character's current health
        this.health = health;
    }

    /**
     * Updates maximum health and caps current health if needed.
     *
     * @param maximum
     *            the new maximum health
     * @requires maximum > 0
     * @ensures this.maxHealth = maximum and this.health = min(#this.health,
     *          maximum)
     */
    public void setMaxHealth(int maximum) {
        assert maximum > 0 : "Maximum health must be positive";

        // Update the character's maximum health
        this.maxHealth = maximum;

        // Reduce current health if it exceeds the new maximum
        if (this.health > maximum) {
            this.health = maximum;
        }
    }

    /**
     * Updates the attack statistic.
     *
     * @param attack
     *            the new attack statistic
     * @requires attack >= 0
     * @ensures this.attack = attack
     */
    public void setAttack(int attack) {
        assert attack >= 0 : "Attack cannot be negative";

        // Update the character's attack statistic
        this.attack = attack;
    }

    /**
     * Updates the defense statistic.
     *
     * @param defense
     *            the new defense statistic
     * @requires defense >= 0
     * @ensures this.defense = defense
     */
    public void setDefense(int defense) {
        assert defense >= 0 : "Defense cannot be negative";

        // Update the character's defense statistic
        this.defense = defense;
    }

    /**
     * Reduces current health without going below zero.
     *
     * @param damage
     *            the amount of damage taken
     * @requires damage >= 0
     * @ensures this.health = max(0, #this.health - damage)
     */
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
    public void heal(int amount) {
        assert amount >= 0 : "Healing cannot be negative";

        // Retrieve current health and calculate missing health
        int currentHealth = this.health();
        int maximumHealth = this.maxHealth();
        int missingHealth = maximumHealth - currentHealth;

        // Restore health without exceeding the maximum
        if (amount >= missingHealth) {
            this.setHealth(maximumHealth);
        } else {
            this.setHealth(currentHealth + amount);
        }
    }

    /**
     * Reports whether the character is alive.
     *
     * @return true if current health is greater than zero
     * @ensures isAlive = (this.health > 0)
     */
    public boolean isAlive() {
        // A character is alive when current health is above zero
        return this.health() > 0;
    }

    /**
     * Reports the amount of missing health.
     *
     * @return the amount of missing health
     * @ensures healthMissing = this.maxHealth - this.health
     */
    public int healthMissing() {
        // Calculate the difference between maximum and current health
        return this.maxHealth() - this.health();
    }

    /**
     * Displays the character's statistics.
     *
     * @param out
     *            the output stream
     * @requires out is open
     * @ensures the character statistics are printed to out
     */
    public void displayStats(SimpleWriter out) {
        // Verify that the output stream exists and is open
        assert out != null : "Output stream cannot be null";
        assert out.isOpen() : "Output stream must be open";

        // Display the character's current statistics
        out.println("Health: " + this.health() + "/" + this.maxHealth());
        out.println("Attack: " + this.attack());
        out.println("Defense: " + this.defense());
        out.println("Alive: " + this.isAlive());
    }

    /**
     * Demonstrates the character stat sheet with a menu.
     *
     * @param args
     *            the command-line arguments
     */
    public static void main(String[] args) {
        // Initialize the input and output streams
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // Create a character with the starting statistics
        CharacterStatSheet warrior = new CharacterStatSheet(STARTING_HEALTH,
                STARTING_ATTACK, STARTING_DEFENSE);

        // Initialize the menu selection
        int choice = -1;

        out.println("=== RPG Character Stat Sheet ===");

        // Continue displaying the menu until the user chooses to exit
        while (choice != 0) {
            // Display the available character actions
            out.println();
            out.println("1. Display Character Stats");
            out.println("2. Take Damage");
            out.println("3. Heal Character");
            out.println("4. Upgrade Attack");
            out.println("5. Upgrade Defense");
            out.println("6. Restore Full Health");
            out.println("0. Exit");
            out.print("Enter your choice: ");

            // Read the user's selected action
            choice = in.nextInteger();
            out.println();

            if (choice == 1) {
                // Display the character's current statistics
                warrior.displayStats(out);

            } else if (choice == 2) {
                // Apply damage and display the updated statistics
                warrior.takeDamage(DAMAGE_AMOUNT);
                out.println("Character took " + DAMAGE_AMOUNT + " damage.");
                warrior.displayStats(out);

            } else if (choice == 3) {
                // Restore health and display the updated statistics
                warrior.heal(HEAL_AMOUNT);
                out.println("Character healed for up to " + HEAL_AMOUNT
                        + " health.");
                warrior.displayStats(out);

            } else if (choice == 4) {
                // Retrieve the character's current attack statistic
                int currentAttack = warrior.attack();

                // Increase attack if the result stays within the integer range.
                if (currentAttack <= Integer.MAX_VALUE - UPGRADE_AMOUNT) {
                    warrior.setAttack(currentAttack + UPGRADE_AMOUNT);
                    out.println("Attack increased!");
                } else {
                    out.println("Attack cannot increase further.");
                }

                // Display the updated statistics
                warrior.displayStats(out);

            } else if (choice == 5) {
                // Retrieve the character's current defense statistic
                int currentDefense = warrior.defense();

                // Increase defense if the result stays within the integer range
                if (currentDefense <= Integer.MAX_VALUE - UPGRADE_AMOUNT) {
                    warrior.setDefense(currentDefense + UPGRADE_AMOUNT);
                    out.println("Defense increased!");
                } else {
                    out.println("Defense cannot increase further.");
                }

                // Display the updated statistics
                warrior.displayStats(out);

            } else if (choice == 6) {
                // Restore the character's health to its maximum value
                warrior.setHealth(warrior.maxHealth());
                out.println("Health fully restored!");
                warrior.displayStats(out);

            } else if (choice == 0) {
                // End the demonstration when the user selects exit
                out.println("Exiting Character Stat Sheet.");

            } else {
                // Inform the user when an invalid menu option is selected
                out.println("Invalid choice. Please try again.");
            }
        }

        // Close the input and output streams
        in.close();
        out.close();
    }
}
