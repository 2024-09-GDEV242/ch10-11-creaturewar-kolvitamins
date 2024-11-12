import java.util.ArrayList;
/**
 * Battle sim creates 2 armies and pits them against each other. Both armies must be created before being able to 
 * use the battle method. 
 *
 * @author Jeffrey Kolvites
 * @version 11/12/24
 */
public class BattleSim
{
    private ArrayList<Creature> armyOne = new ArrayList<Creature>();
    private ArrayList<Creature> armyTwo = new ArrayList<Creature>();

    /**
     * Creates the army of light. This army for this army to win there must be more units that in army 2.
     * @param the size of the army
     */
    public void createArmyOne(int armyOneSize)
    {
        for(int i = 0; i < armyOneSize; i++)
        {
            int rand = Randomizer.nextInt(10);
            if(rand <= 6){
                Human human = new Human();
                armyOne.add(human);
            }else{
                Elf elf = new Elf();
                armyOne.add(elf);
            }
        }
    }
    
    /**
     * Creates the army of darkness. If this army is larger than army 1 it will certainly win.
     * @param the size of the army
     */
    public void createArmyTwo(int armyTwoSize)
    {
        for(int i = 0; i < armyTwoSize; i++)
        {
            int rand = Randomizer.nextInt(25);
            if (rand <= 18){
                Human human = new Human();
                armyTwo.add(human);
            }else if(rand > 18 && rand <= 24){
                CyberDemon cyberDemon = new CyberDemon();
                armyTwo.add(cyberDemon);
            }else{
                Balrog balrog = new Balrog();
                armyTwo.add(balrog);
            }
        }
    }

    /**
     * The battle method pits the two created armies against each other and prints out information
     * such as attack, damage done, remaining health and if the creature has died. Creatures fight
     * one at a time until one army runs out of creatures. Selects a random value between 1 and 2 
     * to determine who attacks.
     */
    public void battle()
    {
    if(armyOne.size() != 0 && armyTwo.size() != 0){
        System.out.println("The armies of light and darkness find each other face to face...");
        wait(3000);
        System.out.println("The battle begins!");
        wait(2000);
        while (armyOne.size() != 0 && armyTwo.size() != 0)
        {
            Creature gladiatorOne = armyOne.get(0);
            Creature gladiatorTwo = armyTwo.get(0);
            
            int diceRoll = Randomizer.nextInt(2);
            if(diceRoll == 1){
                int battleAttack = gladiatorOne.attack(); //holds attack info
                System.out.println("The holy " + gladiatorOne.getClass().getSimpleName() + " strikes the fell "
                                    + gladiatorTwo.getClass().getSimpleName()
                                    + " for " + battleAttack + " damage!");
                gladiatorTwo.takeDamage(battleAttack);
                System.out.println("The fell " + gladiatorTwo.getClass().getSimpleName() + " has " + gladiatorTwo.getHealth()
                                    + " HP remaining");
                wait(500); //so you might be able to read whats happening
                if(!gladiatorTwo.isAlive()){
                    System.out.println("☠️The fell " + gladiatorTwo.getClass().getSimpleName() + " has died ☠");
                    System.out.println("-------------------------------");
                    armyTwo.remove(0);
                    wait(500);
                }
            }else{
                int battleAttack = gladiatorTwo.attack(); //holds attack info
                System.out.println("The fell " + gladiatorTwo.getClass().getSimpleName() + " strikes the holy " 
                                + gladiatorOne.getClass().getSimpleName()
                                + " for " + battleAttack + " damage!");
                gladiatorOne.takeDamage(battleAttack);
                System.out.println("The holy " + gladiatorOne.getClass().getSimpleName() + " has " + gladiatorOne.getHealth()
                                    + " HP remaining");
                wait(500); //so you might be able to read whats happening
                if(!gladiatorOne.isAlive()){
                    System.out.println("☠️The holy " + gladiatorOne.getClass().getSimpleName() + " has died ☠");
                    System.out.println("-------------------------------");
                    armyOne.remove(0);
                    wait(500);
                }
            }
        }
        System.out.println("The dust has settled...");
        System.out.println("Army One has " + armyOne.size() + " combatants");
        System.out.println("Army Two has " + armyTwo.size() + " combatants");
        if(armyOne.size() > armyTwo.size()){
            System.out.println("The sun shines bright. The forces of Good have prevailed!");
        }else{
            System.out.println("A dark wind blows. Demonic forces have won this day...");
        }
        
    }else{
        System.out.println("You must create both armies before the battle can begin");
    }
    }
       
    /**
     * Waits for a specified number of milliseconds before finishing. Used to slow the flow of battle.
     * @param  milliseconds  the number 
     */
    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }
}
