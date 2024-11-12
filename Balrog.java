
/**
 * The Balrog class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [100/50]
 * Implements a maximum/minimum hitpoint total for the creature type [200/80]
 * Implements a double attack. Balrog will always attack twice
 *
 * @author Jeff Kolvites
 * @version 11/09/24
 */
public class Balrog extends Demon
{
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Constructor for objects of class Balrog
     */
    public Balrog()
    {
        super(
            Randomizer.nextInt(MAX_BALROG_HP-MIN_BALROG_HP)+MIN_BALROG_HP,    
            Randomizer.nextInt(MAX_BALROG_STR-MIN_BALROG_STR)+MIN_BALROG_STR
        );
    }

    /**
     * Initalizes balrog creature. Inherits hp and strength from demon class.
     * @param hp, str
     */
    public Balrog(int hp, int str)
    {
         super(hp, str);
    }
    
    /**
     * Attack for Balrog class. Inherits attack from Demon class and attacks again, once for each hand.
     * @return damage dealt
     */
    public int attack()
    {
        int balrogAttack = super.attack();
        balrogAttack += super.attack();
        return balrogAttack;
    }
    
}
