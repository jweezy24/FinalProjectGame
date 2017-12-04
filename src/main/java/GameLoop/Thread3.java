package GameLoop;

import player.Player;

import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread3 {
    public Player user;
    public WorldGeneration world;
    public Thread3(Player player , WorldGeneration world)
    {
        user = player;
        this.world = world;
    }

    public void run()
    {
        Scanner userInput = new Scanner(System.in);
        Narrator narrator = new Narrator();
        String choice = "";
        while(user.isAlive())
        {
            narrator.newEvent(world.event);
            if(world.event.type.toLowerCase().equals("dungeon"))
            {
                world.event.dungeon.getRoom();
            }


        }
    }
}
