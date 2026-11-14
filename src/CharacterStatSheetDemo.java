import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.statsheet.CharacterStatSheet;
import components.statsheet.CharacterStatSheet1L;

/**
 * Demonstrates the CharacterStatSheet compponent in an rpg.
 *
 * @author Connor Stanfield
 */
public final class CharacterStatSheetDemo {

    /**
     * Starting max health.
     */
    private static final int STARTING_HEALTH = 100;

    /**
     * Starting attack.
     */
    private static final int STARTING_ATTACK = 20;

    /**
     * Starting defense.
     */
    private static final int STARTING_DEFENSE = 10;

    /**
     * Amount of damage taken.
     */
    private static final int DAMAGE = 25;

    /**
     * Amount of healing received.
     */
    private static final int HEALING = 20;

    /**
     * Private constructor to prevent instantiation.
     */
    private CharacterStatSheetDemo() {
    }

    /**
     * Demonstrates combat and healing.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        // Create the output stream
        SimpleWriter out = new SimpleWriter1L();

        // Create a character with starting stats
        CharacterStatSheet warrior = new CharacterStatSheet1L(STARTING_HEALTH,
                STARTING_ATTACK, STARTING_DEFENSE);

        // Display the starting stats
        out.println("Starting Character:");
        out.println(warrior);
        out.println();

        // Demonstrate taking damage
        warrior.takeDamage(DAMAGE);
        out.println("After taking damage:");
        out.println(warrior);
        out.println();

        // Demonstrate healing
        warrior.heal(HEALING);
        out.println("After healing:");
        out.println(warrior);
        out.println();

        // Close the output stream
        out.close();
    }

}
