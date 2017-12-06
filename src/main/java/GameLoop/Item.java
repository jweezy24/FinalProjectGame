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
    public int healing = 0;
    public String equipmentType;
    public List<String> equipment = Arrays.asList("helmet", "armor", "weapon", "legs", "boots", "backpack");
    public Item(int level)
    {
        this.level = level;
        generateStats();
    }
    //This is only to be called by shops, pubs and Inns.
    public Item()
    {
        generateConsumable();
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

    public void generateConsumable()
    {
        Random choice = new Random();
        int type = choice.nextInt(1);
        switch (type)
        {
            case 1:
                equipmentType = consumables.potion.toString();
                healing = 50;
                break;
            case 0:
                equipmentType = consumables.food.toString();
                healing = 20;
                break;


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

enum consumables
        {
            potion,food,
        }
