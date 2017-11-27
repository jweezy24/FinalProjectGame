package GameLoop;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
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
    public boolean chest = false;
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
                break;
            case nothing:
                break;
            case boss:
                break;

        }

    }

    public void createSpecificRoom(Rooms config)
    {
        Rooms [] temp = Rooms.values();
        Random room = new Random();
        Rooms value = temp[room.nextInt(temp.length-1)-temp.length-1];
        switch (value){
            case enemies:
                System.out.println("Here");
                this.enemies = RoomWithEnemies();
                break;
            case chest:
                break;
            case nothing:
                break;
            case boss:
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
    public Enemies createBossRoom()
    {

        return new Enemies(levelRequirement+3);


    }
    public void RoomWithChest()
    {

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
        if(boss)
        {
            string += "\n This is a boss room "  + enemies.get(0).toString();
        }

        return string;
    }

    }



