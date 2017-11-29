package GameLoop;

import java.util.Random;

/**
 * Created by jwest1 on 11/29/2017.
 */
public class Item {
    public int level;
    public int strength;
    public int intel;
    public int stamina;

    public Item(int level)
    {
        this.level = level;
        generateStats();
    }

    public void generateStats()
    {
        Random generator = new Random();

        this.strength = generator.nextInt(level *10 );
        this.intel = generator.nextInt(level *10);
        this.stamina = generator.nextInt(level*10);


    }
    public String toString()
    {
        String stats = "Item level is " + level + "\n" +
                "Item Strength is " + strength + "\n"+
                "Item Intelligence is " + intel + "\n"+
                "Item Stamina is " + stamina + "\n";

        return stats;

    }

}
