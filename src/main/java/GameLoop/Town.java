package GameLoop;

import Utilities.LinkedStack;
import player.User;

import java.util.Random;

/**
 * Created by jwest1 on 11/27/2017.
 */
public class Town {
    //public User player;
    public LinkedStack<Item> [] shopItems = new LinkedStack[3];

    public Town()
    {
        //this.player = player;
        generateTown();
    }

    public void generateTown()
    {
        Random generation = new Random();
        int num = generation.nextInt(3);
        for(int i =0; i < 5; i++)
        {
            if(num == 1)
            {
                generateShop();
            }
        }
    }

    public void generateInn()
    {

    }
    public void generatePub()
    {

    }
    public void generateShop()
    {
        for(int i = 0; i < shopItems.length; i++)
        {
            Item tempItem = new Item();
            shopItems[i] = new LinkedStack<Item>();
            for(int p = 0; p < 10; p++ )
            {

                shopItems[i].push(tempItem);

            }
        }

    }
}
