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

}
