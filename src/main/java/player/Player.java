package player;
import org.omg.CORBA.DynAnyPackage.InvalidValue;
import org.omg.IOP.CodecPackage.InvalidTypeForEncoding;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.*;


/**
 * Created by jwest1 on 11/27/2017.
 */
public class Player {
    public String name;
    public String race;
    public String type;
    public int XP;
    public int level = 1;
    public int XPtoLevel;
    public int strength;
    public int intellegence;
    public int stamina;
    public int hp;
    public int mp;
    public int hpMax;
    public int mpMax;
    public HashMap raceStats = new HashMap();
    public List<Integer> digits = new ArrayList<Integer>();

    public Player(String name, String race, String type)
    {
        this.name = name.toLowerCase();
        this.race = race.toLowerCase();
        this.type = type.toLowerCase();
        generateStats();
        generateRaceStats();
    }
    public void generateRaceStats() {
        raceStats.put(1,11514);
        raceStats.put(2,42222);
        raceStats.put(3,15141);
        String temp;
        int temp2;
        if (this.race.equals("orc")){
            temp = raceStats.get(1).toString();
            temp2 = Integer.parseInt(temp);
            gen(temp2);
            hpMax += digits.get(0);
            mpMax += digits.get(1);
            strength += digits.get(2);
            intellegence += digits.get(3);
            stamina += digits.get(4);
            hp = hpMax;
            mp = mpMax;
        }
        if (this.race.equals("human")){
            temp = raceStats.get(2).toString();
            temp2 = Integer.parseInt(temp);
            gen(temp2);
            hpMax += digits.get(0);
            mpMax += digits.get(1);
            strength += digits.get(2);
            intellegence += digits.get(3);
            stamina += digits.get(4);
            hp = hpMax;
            mp = mpMax;
        }
        if (this.race.equals("elf")){
            temp = raceStats.get(3).toString();
            temp2 = Integer.parseInt(temp);
            gen(temp2);
            hpMax += digits.get(0);
            mpMax += digits.get(1);
            strength += digits.get(2);
            intellegence += digits.get(3);
            stamina += digits.get(4);
            hp = hpMax;
            mp = mpMax;
        }

    }
    public void gen(int temp) {
        while(temp> 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
    }
    public void generateStats()
    {
        Random Topgenerator = new Random();
        Random MidGenerator = new Random();
        Random LowGenerator = new Random();

        if (this.type.equals("warrior"))
        {
            strength = Topgenerator.nextInt(100);
            stamina = MidGenerator.nextInt(50);
            intellegence = LowGenerator.nextInt(25);
            hpMax += 15;
            mpMax += 0;
            hp = hpMax;
            mp = mpMax;
        }
        if(this.type.equals("mage"))
        {
            intellegence = Topgenerator.nextInt(100);
            stamina = MidGenerator.nextInt(50);
            strength = LowGenerator.nextInt(25);
            hpMax += 5;
            mpMax += 15;
            hp = hpMax;
            mp = mpMax;
        }
        if(this.type.equals("thief"))
        {
            stamina = Topgenerator.nextInt(100);
            intellegence = MidGenerator.nextInt(50);
            strength = LowGenerator.nextInt(25);
            hpMax += 10;
            mpMax += 10;
            hp = hpMax;
            mp = mpMax;
        }
    }
    public void addXP(int XP)
    {
        this.XP += XP;
        if(this.XP >= XPtoLevel)
        {
            level+=1;
            levelUp();
            if (race.equals("orc")){
                hpMax += 4;
                hp = hpMax;
                mpMax ++;
                mp = mpMax;
            }
            if (race.equals("human")){
                hpMax += 3;
                hp = hpMax;
                mpMax += 2;
                mp = mpMax;
            }
            if (race.equals("elf")){
                hpMax += 2;
                hp = hpMax;
                mpMax += 4;
                mp = mpMax;
            }

        }
    }
    public void levelUp()
    {
        Random skillGenereation = new Random(10);
        int choice = 0;
        int skillPoints = level * skillGenereation.nextInt();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the skill then the amount (strength 10) this will add 10 skill points to strength");
        System.out.println("How to pick the stat you want, type strength, intel for intelligence, or stamina");
        String [] input = new String[2];
        while(skillPoints >= 0)
        {
            System.out.println("Choose a place to put skill points, you have  " + skillPoints + " points left");
            String place = scan.nextLine();
            try
            {
                input = place.split(" ");
            }catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Please enter the what you want correctly (stat points)");
            }
            try
            {
                choice = Integer.parseInt( input[1]);

            }catch (NumberFormatException e)
            {
                System.out.println("The value you entered is not a integer, the correct way to enter is (skill points)");
                continue;

            }

            if(input[0].toLowerCase().equals("strength")||input[0].toLowerCase().equals("intel")|| input[0].toLowerCase().equals("stamina"))
            {
                if(input[0].toLowerCase().equals("strength"))
                {
                    this.strength += choice;

                }
                if(input[0].toLowerCase().equals("intel"))
                {
                    this.intellegence += choice;

                }
                if(input[0].toLowerCase().equals("stamina"))
                {
                    this.stamina += choice;

                }
            }


        }
    }

    public boolean isAlive()
    {
        if(hp >0 )
            return true;
        return false;
    }

    public String toString()
    {
        String stats = "Your name is " + name + " \n"+
                "Your level is " + level + "\n" +
                "Your Strength is " + strength + "\n"+
                "Your Intelligence is " + intellegence + "\n"+
                "Your Stamina is " + stamina + "\n" +
                "Your current HP is " + hp + "\n" +
                "Your Max HP is " + hpMax + "\n" +
                "Your current MP is " + mp + "\n" +
                "Your Max MP is " + mpMax + "\n";


        return stats;
    }



}
