/**
 * The Cyber demon class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [40/20]
 * Implements a maximum/minimum hitpoint total for the creature type [100/25]
 * 
 * @author Jeff Kolvites
 * @version 11/09/24
 */
public class CyberDemon extends Demon
{
    private static final int MAX_DEMON_HP = 100;
    private static final int MIN_DEMON_HP = 25;
    private static final int MAX_DEMON_STR = 40;
    private static final int MIN_DEMON_STR = 20;
    /**
     * Constructor for objects of class CyberDemon
     */
    public CyberDemon()
    {
        super(
            Randomizer.nextInt(MAX_DEMON_HP-MIN_DEMON_HP)+MIN_DEMON_HP,    
            Randomizer.nextInt(MAX_DEMON_STR-MIN_DEMON_STR)+MIN_DEMON_STR
        );
    }

    /**
     * Initializes the cyber demon creature. Inherits hp and strength from demon class
     *
     * @param  hp, str
     */
    public CyberDemon(int hp, int str)
    {
        super(hp, str);
    }
    
    /**
     * Attack method calculates damage dealt by the Cyber Demon
     * Calls attack from demon class instead of creature.
     * @return damage dealt
     */
    public int attack()
    {
        int demonAttack = super.attack();
        return demonAttack;
    }
}
