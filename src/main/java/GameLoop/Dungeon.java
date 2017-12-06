package GameLoop;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
import player.User;

/**
 * Created by jwest1 on 11/27/2017.
 */
public class Dungeon {
    public final int MAXROOMS = 10;
    public int DUNGEONLEVEL = 0;
    public List<Room> rooms = new ArrayList<>();

    public Dungeon(int level)
    {
        this.DUNGEONLEVEL = level;
        generateRooms();
    }

    public void generateRooms()
    {
        int count = 0;
        while(count <= MAXROOMS-1)
        {
            rooms.add(new Room(this.DUNGEONLEVEL));
            count+=1;
        }
        rooms.add(new Room(this.DUNGEONLEVEL, Rooms.boss));
    }
    public Room getRoom( int index)
    {
        Room tempRoom = rooms.get(index);
        return tempRoom;
    }
    public String toString()
    {
        String string = "";
        for(int i = 0; i < rooms.size(); i++)
        {
            string += "Room " + i + rooms.get(i).toString() + "\n";
        }
        return string;
    }

}

enum Rooms
{
    enemies,chest,nothing,boss
}


class Room
{
    public List<Enemies> enemies = new ArrayList<Enemies>();
    public boolean isEnemy = false;
    public Chest chest;
    public boolean isChest = false;
    public boolean nothing = false;
    public boolean boss = false;
    public int levelRequirement;
    public Room(int level)
    {
        this.levelRequirement = level;
     createRoom();
    }
    public Room(int level, Rooms config)
    {
        this.levelRequirement = level;
        if(config == Rooms.boss)
        {
            boss = true;
            enemies.add(createBossRoom());
        }

    }

    public void createRoom()
    {
        Rooms [] temp = Rooms.values();
        Random room = new Random();
        Rooms value = temp[room.nextInt(temp.length-1)];
        switch (value){
            case enemies:
                isEnemy = true;
                this.enemies = RoomWithEnemies();
                break;
            case chest:
                isChest = true;
                this.chest = RoomWithChests();
                break;
            case nothing:
                break;

        }

    }


    public List<Enemies> RoomWithEnemies()
    {
        List<Enemies> enemies = new ArrayList<Enemies>();
        Random generator = new Random();
        int total = generator.nextInt(5);
        for(int i = 0; i < total; i++)
        {
            enemies.add(new Enemies(this.levelRequirement));
        }
        return enemies;


    }
    public Chest RoomWithChests()
    {
        Chest chest = new Chest(this.levelRequirement);



        return chest;


    }
    public Enemies createBossRoom()
    {

        return new Enemies(levelRequirement+3);


    }
    public void RoomWithChest()
    {

    }

    public void playerInRoom(User player, Narrator nar) {
        Scanner userInput = new Scanner(System.in);
        String choice = "";
        Enemies tempEnmey;
        Random goesFirst = new Random();
        int playerAttack = 0;
        Item item = null;

        if (isEnemy || boss) {
            for (int i = 0; i < enemies.size(); i++) {
                tempEnmey = enemies.get(i);
                tempEnmey.attackQueue();
                while (tempEnmey.alive && player.isAlive()) {
                    if (isEnemy)
                        nar.BattleLines(player, tempEnmey);
                    if (boss)
                        nar.BossRoom(player, tempEnmey);
                    choice = userInput.nextLine();
                    if (choice.equals("a")) {
                        int first = goesFirst.nextInt(2);
                        if (first == 0) {
                            playerAttack = player.Attack();
                            tempEnmey.attacked(playerAttack);

                            player.hp -= tempEnmey.attacks.poll();
                            if (!tempEnmey.alive) {

                                item = nar.EnemyDefeated(player, tempEnmey);
                                if (item != null) {
                                    nar.pickUpItem();
                                    choice = userInput.nextLine();
                                    if (choice.equals("e")) {
                                        player.grabItem(item);
                                    }
                                }
                                continue;
                            }//if the enemy dies

                        } else {
                            playerAttack = player.Attack();
                            player.hp -= tempEnmey.attacks.poll();
                            tempEnmey.attacked(playerAttack);
                            if (!tempEnmey.alive) {

                                item = nar.EnemyDefeated(player, tempEnmey);
                                if (item != null) {
                                    nar.pickUpItem();
                                    choice = userInput.nextLine();
                                    if (choice.equals("e")) {
                                        player.grabItem(item);
                                    }
                                }
                                continue;
                            }//if the enemy dies

                        }//turn calculator

                    }// if the user chooses to attack
                    if (choice.equals("s")) {
                        int first = goesFirst.nextInt(2);
                        if (first == 0) {
                            playerAttack = player.Spell();
                            tempEnmey.attacked(playerAttack);

                            player.hp -= tempEnmey.attacks.poll();
                            if (!tempEnmey.alive) {

                                item = nar.EnemyDefeated(player, tempEnmey);
                                if (item != null) {
                                    nar.pickUpItem();
                                    choice = userInput.nextLine();
                                    if (choice.equals("e")) {
                                        player.grabItem(item);
                                    }
                                }
                                continue;
                            }//if the enemy dies

                        } else {
                            playerAttack = player.Attack();
                            player.hp -= tempEnmey.attacks.poll();
                            tempEnmey.attacked(playerAttack);
                            if (!tempEnmey.alive) {

                                item = nar.EnemyDefeated(player, tempEnmey);
                                if (item != null) {
                                    nar.pickUpItem();
                                    choice = userInput.nextLine();
                                    if (choice.equals("e")) {
                                        player.grabItem(item);
                                    }
                                }
                                continue;
                            }//if the enemy dies
                        }//turn calculator
                    }// if the user chooses to attack
                }//end of the while loop
            }// end of the for loop
        }// end of enemy event handler
        if (isChest) {
            nar.ChestRoom();
            String input = userInput.nextLine();

            if (input.toLowerCase().equals("e")) {
                for (int i = 0; i < chest.items.size(); i++) {
                    System.out.println("You found " + chest.items.get(i).equipmentType + " press i to inspect or enter to skip");
                    input = userInput.nextLine();
                    if (input.toLowerCase().equals("i")) {
                        System.out.println(chest.items.get(i));
                        System.out.println("If you would like to take the item press e.");
                        input = userInput.nextLine();
                        if (input.toLowerCase().equals("e")) {
                            player.grabItem(chest.items.get(i));
                        }
                    }// inspecting the armor
                }// iterate through the items in the chest
            }//if the user chooses to open it
        }// if chest
        if (nothing) {
            System.out.println("There is nothing in this room press any key to continue.");
        }
    }


    public String toString()
    {
        String string = "";
        if(isEnemy)
        {
            string += "\nThis is a normal enemy Room \n";
            for(int i =0; i< enemies.size(); i++)
            {
                string += enemies.get(i).toString() + "\n";
            }
        }
        if(isChest)
        {
            string += "\nThis is a room with a chest! \n";
            string += chest.toString();
        }
        if(boss)
        {
            string += "\n This is a boss room "  + enemies.get(0).toString();
        }

        return string;
    }

    }



