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
    public Events(int level)
    {
        this.level = level;
        generateEvents();
    }
    public void generateEvents()
    {
        Random event = new Random(3);
        int generation = 1;
        if(generation == 1)
        {
            type = "Dungeon";
            this.dungeon = new Dungeon(level);
            dungeonList.add(this.dungeon);
        }
    }
    public String toString()
    {
     return type + " " + dungeon.toString();
    }
}
