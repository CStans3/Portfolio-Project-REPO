import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Character stat sheet represented using a Sequence of integers.
 *
 * @convention <pre>
 *             this.stats /= null and
 *             this.stats.length() = 4 and
 *             0 <= this.stats.entry(0) and
 *             this.stats.entry(0) <= this.stats.entry(1) and
 *             this.stats.entry(1) > 0 and
 *             this.stats.entry(2) >= 0 and
 *             this.stats.entry(3) >= 0
 *             </pre>
 * @correspondence <pre>
 *                 this = (
 *                     health = this.stats.entry(0),
 *                     maxHealth = this.stats.entry(1),
 *                     attack = this.stats.entry(2),
 *                     defense = this.stats.entry(3)
 *                 )
 *                 </pre>
 *
 * @author Connor Stanfield
 */
public class CharacterStatSheet1L extends CharacterStatSheetSecondary {

    /**
     * Index of current health in the sequence.
     */
    private static final int HEALTH_INDEX = 0;

    /**
     * Index of max health in the sequence.
     */
    private static final int MAX_HEALTH_INDEX = 1;

    /**
     * Index of attack in the sequence.
     */
    private static final int ATTACK_INDEX = 2;

    /**
     * Index of defense in the sequence.
     */
    private static final int DEFENSE_INDEX = 3;

    /**
     * Default maximum health.
     */
    private static final int DEFAULT_HEALTH = 100;

    /**
     * Default value for attack & defense.
     */
    private static final int DEFAULT_STAT = 0;

    /**
     * Sequence containing the character's statistics.
     */
    private Sequence<Integer> stats;

    /**
     * Initializes the representation to its initial value.
     */
    private void createNewRep() {
        // Create an empty sequence for thew statistics
        this.stats = new Sequence1L<Integer>();

        // Add the default stats in their required order
        this.stats.add(this.stats.length(), DEFAULT_HEALTH);
        this.stats.add(this.stats.length(), DEFAULT_HEALTH);
        this.stats.add(this.stats.length(), DEFAULT_STAT);
        this.stats.add(this.stats.length(), DEFAULT_STAT);
    }

    /**
     * Creates a character with default statistics.
     */
    public CharacterStatSheet1L() {
        // Initialize the character's represenation
        this.createNewRep();
    }

    /**
     * Creates a character with the given statistics.
     *
     * @param maxHealth
     *            the maximum health
     * @param attack
     *            the attack stat
     * @param defense
     *            the defense stat
     * @requires maxHealth > 0 && attack >= 0 && defense >= 0
     */
    public CharacterStatSheet1L(int maxHealth, int attack, int defense) {
        assert maxHealth > 0 : "Max health must be positive";
        assert attack >= 0 : "Attack can't be negative";
        assert defense >= 0 : "Defense can't be negative";

        // Initialize the representation with default stats
        this.createNewRep();

        // Replace the defaults with the provided stats
        this.setMaxHealth(maxHealth);
        this.setHealth(maxHealth);
        this.setAttack(attack);
        this.setDefense(defense);
    }

    /**
     * Reports the character's current health.
     *
     * @return the current health
     */
    @Override
    public int health() {
        // Retrieve current health from the sequence
        return this.stats.entry(HEALTH_INDEX);
    }

    /**
     * Reports the character's maximum health.
     *
     * @return the max health
     */
    @Override
    public int maxHealth() {
        // Retrieve maximum health from the sequence
        return this.stats.entry(MAX_HEALTH_INDEX);
    }

    /**
     * Reports the character's attack statistic.
     *
     * @return the attack stat
     */
    @Override
    public int attack() {
        // Retrieve attack stat from the sequence
        return this.stats.entry(ATTACK_INDEX);
    }

    /**
     * Reports the character's defense statistic.
     *
     * @return the defense stat
     */
    @Override
    public int defense() {
        // Retrieve defense stat from the sequence
        return this.stats.entry(DEFENSE_INDEX);
    }

    /**
     * Updates the character's current health.
     *
     * @param health
     *            the new current health
     */
    @Override
    public void setHealth(int health) {
        assert health >= 0 && health <= this
                .maxHealth() : "Health must be within the allowed range";

        // Replace the current health with the new value
        this.stats.replaceEntry(HEALTH_INDEX, health);
    }

    /**
     * Updates max health and caps current health if needed.
     *
     * @param maximum
     *            the new maximum health
     */
    @Override
    public void setMaxHealth(int maximum) {
        assert maximum > 0 : "Maximum health must be positive";

        // Replace the maximum health value
        this.stats.replaceEntry(MAX_HEALTH_INDEX, maximum);

        // Reduce current health if it exceeds the new maximum
        if (this.health() > maximum) {
            this.stats.replaceEntry(HEALTH_INDEX, maximum);
        }

    }

    /**
     * Updates the character's attack statistic.
     *
     * @param attack
     *            the new attack stat
     */
    @Override
    public void setAttack(int attack) {
        assert attack >= 0 : "Attack can't be negative";

        // Replace the attack value
        this.stats.replaceEntry(ATTACK_INDEX, attack);
    }

    /**
     * Updates the character's defense statistic.
     *
     * @param defense
     *            the new defense stat
     */
    @Override
    public void setDefense(int defense) {
        assert defense >= 0 : "Defense can't be negative";

        // Replace the defense value
        this.stats.replaceEntry(DEFENSE_INDEX, defense);
    }
}
