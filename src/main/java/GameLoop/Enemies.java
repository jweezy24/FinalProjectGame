package GameLoop;
import Utilities.FightQueue;

import java.util.Map;
import java.util.Random;

public class Enemies {
    public int level = 0;
    public int attack = 0;
    public int defense =0;
    public int health = 1;
    public boolean alive = true;
    public FightQueue<Integer> attacks;

    public Enemies(int level)
    {
     this.level = level;
     generateStats();
     this.attacks = new FightQueue<>(100);
    }
    public void generateStats()
    {
        Random bound = new Random();
        attack = bound.nextInt(10*level)+1;
        defense = bound.nextInt(10*level)+1;
        health = bound.nextInt(20*level)+1;

    }
    public void attacked(int attackPoints)
    {
        attackPoints = (attackPoints+defense)/2;
        health -= attackPoints;
        if(health<= 0)
        {
         alive = false;
        }
    }

    public void attackQueue()
    {
        Random generateMove = new Random();
        Random generateDamage = new Random();
        int choice  = 0;
        Integer defense = 0;
        for(int i = 0; i < 30; i++)
        {
            choice  = generateMove.nextInt(2);
            if(choice == 1)
            {
                Integer damage = generateDamage.nextInt(attack)+1;
                attacks.offer(damage);
            }else
                {
                    attacks.offer(defense);
                }
        }
    }

    public int deadXP()
    {
        int xp = 1;
        Random generateXp = new Random();
        xp = generateXp.nextInt(level*3)+level*2;
        return xp;
    }

    public Item deadItem()
    {
        Random generateDrop = new Random();
        int drop = generateDrop.nextInt(1);
        if(drop == 1)
        {
        Item item = new Item(level);
        return item;
        }
        else
            {
                return null;
            }
    }

    public String toString()
    {
        String string = "This enemy has: \n" +
                "Level = " + level + "\n"+
                "Fight = " + attack + "\n"+
                "Defense = " + defense + "\n";
        return string;
    }

}
