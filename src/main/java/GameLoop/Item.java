package GameLoop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by jwest1 on 11/29/2017.
 */
public class Item {
    public int level;
    public int strength;
    public int intel;
    public int stamina;
    public int backpackSize;
    public String equipmentType;
    public List<String> equipment = Arrays.asList("helmet", "armor", "weapon", "legs", "boots", "backpack");
    public Item(int level)
    {
        this.level = level;
        generateStats();
    }

    public void generateStats()
    {
        Random generator = new Random();
        int temp;
        this.strength = generator.nextInt(level *10 );
        this.intel = generator.nextInt(level *10);
        this.stamina = generator.nextInt(level*10);
        temp = generator.nextInt(5);
        this.equipmentType = equipment.get(temp);
        if (equipmentType.equals("backpack")){
            this.backpackSize = generator.nextInt(20);
        }

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
