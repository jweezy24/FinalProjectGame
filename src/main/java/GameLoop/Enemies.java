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
    public FightQueue<Integer> attacks = new FightQueue<>(100);

    public Enemies(int level)
    {
     this.level = level;
     generateStats();
    }
    public void generateStats()
    {
        Random bound = new Random();
        attack = bound.nextInt(10*level)+level*2;
        defense = bound.nextInt(10*level)+level*2;
        health = bound.nextInt(20*level)+level*2;

    }
    public void attacked(int attackPoints)
    {
        attackPoints = attackPoints-defense;
        health-= attackPoints;
        if(health<= 0)
        {
         alive = false;
        }
    }

    public void attackQueue()
    {
        Random generateMove = new Random();
        Random generateDamage = new Random();
        int choice  = generateMove.nextInt(1);
        for(int i = 0; i < attacks.size(); i++)
        {
            if(choice == 1)
            {
                int damage = generateDamage.nextInt(attack)+1;
                attacks.offer(damage);
            }else
                {
                    attacks.offer(0);
                }
        }
    }

    public int deadXP()
    {
        int xp = 0;
        Random generateXp = new Random();
        xp = generateXp.nextInt(level*3);
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
