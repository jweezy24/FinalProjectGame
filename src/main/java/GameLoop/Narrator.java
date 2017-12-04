package GameLoop;

/**
 * Created by jwest1 on 11/29/2017.
 */

public class Narrator {

    public Narrator()
    {
        System.out.println("Welcome to Dungeon Crawler!");
    }

    public void newEvent(Events event)
    {
        if(event.type.toLowerCase().equals("dungeon"))
        {
            System.out.println("Your next task is to take on a dungeon.");
            dungeonLines();
        }
    }

    public void dungeonLines()
    {
        System.out.println("To continue in the dungeon press enter.");
    }

    public void BattleLines(player.Player1 player, Enemies enemy)
    {
       System.out.println("You are in battle!");
       System.out.println("Your health is " + player.hp);
       System.out.println("Enemy health is " + enemy.health);
       System.out.println("Press I for info about your character, press a to physically attack, press s to use a spell.");

    }

    public Item EnemyDefeated(player.Player1 player, Enemies enemy)
    {
        System.out.println("You won!");
        System.out.println("Enemy dropped, " + enemy.deadXP() );
        Item item = enemy.deadItem();
        if(item != null)
        {
            System.out.println("Enemy dropped, " + item );
        }
        return item;

    }

    public void pickUpItem()
    {
     System.out.print("Enter e to pick up item.");
    }
}
