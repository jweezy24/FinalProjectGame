package GameLoop;
import player.User;

import java.util.Scanner;

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
        Scanner input = new Scanner(System.in);
        System.out.println("To continue in the dungeon press enter.");
        input.nextLine();
    }

    public void BattleLines(User player, Enemies enemy)
    {
       System.out.println("You are in battle!");
       System.out.println("Your health is " + player.hp);
       System.out.println("Enemy health is " + enemy.health);
       System.out.println("Press I for info about your character, press a to physically attack, press s to use a spell.");

    }

    public Item EnemyDefeated(User player, Enemies enemy)
    {
        int xp = enemy.deadXP();
        System.out.println("You won!");
        System.out.println("Enemy dropped, " + xp + " xp");
        player.addXP(xp);
        Item item = enemy.deadItem();
        if(item != null)
        {
            System.out.println("Enemy dropped, " + item );
        }
        return item;

    }

    public void RoomInfo(Room room, int index)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("You are in room " + index + " press i if you want to see what is in the room." );
        if(input.nextLine().toLowerCase().equals("i"))
        {
            System.out.println(room);
        }
    }

    public void BossRoom(User player, Enemies enemy)
    {
        System.out.println("This is the boss of the Dungeon!");
        System.out.println("Your health is " + player.hp);
        System.out.println("Enemy health is " + enemy.health);
        System.out.println("Press I for info about your character, press a to physically attack, press s to use a spell.");
    }

    public void ChestRoom()
    {
        System.out.println("You found a chest! To open it press e.");
    }


    public void pickUpItem()
    {
     System.out.print("Enter e to pick up item.");
    }
}
