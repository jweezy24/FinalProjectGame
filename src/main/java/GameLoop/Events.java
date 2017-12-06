package GameLoop;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by jwest1 on 11/27/2017.
 */
public class Events {
    EventList<Dungeon> dungeonList = new EventList<>();
    public int level;
    public String type;
    public Dungeon dungeon;
    public Town town;

    public Events(int level)
    {
        this.level = level;
        generateEvents();
    }
    public void generateEvents()
    {
        Random event = new Random();
        int generation = event.nextInt(2);
        //int generation = 2;
        if(generation == 1)
        {
            type = "Dungeon";
            this.dungeon = new Dungeon(level);
            dungeonList.add(this.dungeon);
        }
        if(generation == 0)
        {
            type = "Town";
            this.town = new Town();

        }
    }
    public String toString()
    {
     return type + " " + dungeon.toString();
    }
}
