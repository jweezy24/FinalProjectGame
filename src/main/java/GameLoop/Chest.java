package GameLoop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jwest1 on 11/29/2017.
 */
public class Chest {
    public int level;
    public List<Item> items = new ArrayList<>();
    public Chest(int level)
    {
        this.level = level;
        generateItems();
    }
    public void generateItems()
    {
        Random generator = new Random();
        int totalitems = generator.nextInt(3);
        for(int i = 0; i < totalitems; i++)
        {
            items.add(new Item(level));
        }
    }

    public String toString()
    {
        String message = "This chest contains ";
        for(int i = 0; i < items.size(); i++)
        {
            message += "\n " + items.get(i).toString();
        }
        if(items.size() == 0)
        {
            message += "nothing";
        }

        return message;
    }

}
