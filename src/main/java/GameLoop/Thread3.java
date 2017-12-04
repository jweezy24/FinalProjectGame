package GameLoop;

import player.User;

import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread3 {
    public User user;
    public WorldGeneration world;
    public Thread3(User player , WorldGeneration world)
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
            System.out.println(world.event.type);
            if(world.event.type.toLowerCase().equals("dungeon"))
            {
                for(int i = 0; i < world.event.dungeon.rooms.size(); i++)
                {
                    //System.out.println("Here");

                    Room currentRoom = world.event.dungeon.getRoom(i);
                    narrator.RoomInfo(currentRoom, i);
                    currentRoom.playerInRoom(user, narrator);
                }
            }


        }
    }
}
