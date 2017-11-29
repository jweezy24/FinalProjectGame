package GameLoop;
import player.Player;
import GameLoop.Enemies;
import player.Spells;
import java.util.Scanner;
//this might need to be moved to thread

public class Fight {
    public int damage;
    public int mp;
    public int enemyDefense;
    public int strength;
    public Player player;
    public Enemies enemy;
    public Scanner userInput = new Scanner(System.in);
    public String spell;
    public Spells spells;
    // attack might be cosidered skill so it will go to spells that way all in same loop
    public void attack() {
        strength = player.strength;
        enemyDefense = enemy.defense;
        if (strength > enemyDefense*10) {
            damage = strength-enemyDefense*10;
        }
    }
    public void useSpell() {
        boolean temp = true;
        mp = player.mp;
        enemyDefense = enemy.defense;
        while (temp) {
            System.out.println("Please write what spell or skill you want to use.");
            spell = userInput.nextLine();
            if (spell.equals("magicMissile")) {
                damage = spells.maggicMissile(mp, enemyDefense);
                break;
            }


            if (damage == -1){
                System.out.println("You do not have enough MP to use " + spell + "\n" +
                "You currently have " + mp + " MP");
                continue;
            }
        }
    }

}
