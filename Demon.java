/**
 * The Demon class implements a wrapper for the base Creature class with the following additions
 * 5% chance to deal 50 extra damage
 *
 * @author Jeff Kolvites
 * @version 11/09/24
 */
public class Demon extends Creature
{
    /**
     * Constructor
     */
    public Demon()
    {
        super();
    }

    /**
     *  Creates a demon creature. Inherits hp and strength from creature class
     *  @param hp, str
     */
    public Demon(int hp, int str)
    {
        super(hp,str);
    }
    
    /**
     * Attack method for demon. Has a 5% chance to deal an extra 50 damage.
     * @return int for damage. 
     */
    public int attack()
    {
        int demonAttack = Randomizer.nextInt(20);
        int attackInherit = super.attack();
        if(demonAttack == 1)
        {
            System.out.println("\"Foolish mortal. Prepare to die.\"");
            System.out.println("The demon strikes with unholy fire!");
            return attackInherit + 50;
        }
        return attackInherit;
    }

}
