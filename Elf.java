/**
 * The Elf class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [18/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/8]
 * 
 * @author Jeff Kolvites
 * @version 11/09/24
 */
public class Elf extends Creature
{
    // instance variables - replace the example below with your own
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    /**
     * Constructor for objects of class Elf 
     */
    public Elf()
    {
        // note how the class uses the static randomizer class to
        // generate the values. This localizes the need to know 
        // max and min values to this class only
        // max-min is range of values
        // range + min ensures that the values don't start at one.
        super(
            Randomizer.nextInt(MAX_ELF_HP-MIN_ELF_HP)+MIN_ELF_HP,    
            Randomizer.nextInt(MAX_ELF_STR-MIN_ELF_STR)+MIN_ELF_STR
        );
          
    }
    
    /**
     * Attack for elves. 10% chance for the elf to perform a magic attack for 2x damage.
     * @return int of the attack
     */
    public int attack()
    {
        int magicAttack = Randomizer.nextInt(10);
        int attackInherit = super.attack();
        if(magicAttack == 1)
        {
            System.out.println("\"Feel the strength of my ancestors!\"");
            System.out.println("The elf strikes with a magical force!");
            return attackInherit * 2;
        }
        return attackInherit;
    }
}
