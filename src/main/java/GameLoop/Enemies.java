package GameLoop;
import java.util.Random;

public class Enemies {
    public int level = 0;
    public int attack = 0;
    public int defense =0;
    public int health = 1;
    public boolean alive = true;

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

    public String toString()
    {
        String string = "This enemy has: \n" +
                "Level = " + level + "\n"+
                "Attack = " + attack + "\n"+
                "Defense = " + defense + "\n";
        return string;
    }

}
