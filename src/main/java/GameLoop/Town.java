package GameLoop;

import Utilities.LinkedStack;
import player.User;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jwest1 on 11/27/2017.
 */
public class Town {
    //public User player;
    public LinkedStack<Item> [] shopItems = new LinkedStack[3];
    public int InnPrice=0;



    public Town()
    {
        //this.player = player;
        generateTown();
    }

    public void generateTown()
    {
        Random generation = new Random();
        //int num = generation.nextInt(3);
        generateShop();
        generateInn();


    }

    public void generateInn()
    {
        Random generation = new Random();
        InnPrice = generation.nextInt(30);

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
    public void insideShop(User player)
    {
        int ammount = 1;
        System.out.println("You have " + player.money + " dollars");
        System.out.println("Welcome to my shop, please let me know what you like!");
        UserInput input = new UserInput(player);
        String selection = "";
        while(!selection.toLowerCase().equals("x")) {
            System.out.println("To observe the items in the shop, press i if you would like to leave press x.");
            selection = input.Scan();
            if (selection.toLowerCase().equals("i")) {
                for (int i = 0; i < shopItems.length; i++) {
                    System.out.println("We have: " + shopItems[i].peek().equipmentType + " X" + (shopItems[i].asList().size()-1)
                            + " at price "+ shopItems[i].peek().price + " to buy this item press " + i);
                }
                Integer num = input.numberScan("x");
                if (num == null) {
                    while (num == null) {
                        num = input.numberScan();
                    }
                }if(num == 100000)
                {
                   break;

                }

                while(ammount != 0) {
                    if (num < shopItems.length) {
                        System.out.println("How much would you like to purchase? If you changed you mind enter 0.");
                        ammount = input.numberScan();
                        for(int i = 0; i < ammount && player.money > shopItems[num].peek().price; i++)
                        {
                            Item tempItem = shopItems[num].pop();
                            player.money -= tempItem.price;
                            player.inv.addItem(tempItem);
                        }
                        if(player.money < shopItems[num].peek().price)
                        {
                            System.out.println("You don't have enough money to purchase " + shopItems[num].peek().equipmentType);
                        }

                    } else {
                        System.out.println("You have selected too many Items, please enter another number.");
                    }
                }
            }
        }
    }
    public void insideInn(User player)
    {
        UserInput input = new UserInput();
        System.out.println("Welcome to the Inn!");
        System.out.println("To sleep here it will cost " + InnPrice + " dollars");
        System.out.println("To stay the night press e, to leave press x");
        String choice = input.Scan();
        if(choice.equals("e"))
        {
            player.money -= InnPrice;
            System.out.println("You stayed the night at a Inn, your HP is back to full hp");
            player.hp = player.hpMax;
        }
    }
    public void mapOfTown()
    {
        System.out.println("Enter 1 to visit the shop, enter 2 to visit the inn, to leave the town press x.");

    }

    public void playerInTown(User player)
    {
        UserInput input = new UserInput(player);
        mapOfTown();
        String choice = input.Scan();

            if (choice.equals("1")) {
                insideShop(player);
            }
            if (choice.equals("2")) {
                insideInn(player);
            }


    }
}
