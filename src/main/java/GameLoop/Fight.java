package GameLoop;
import player.User;
import player.Spells;
import java.util.Scanner;
//this might need to be moved to thread

public class Fight {
    public int damage;
    public int mp;
    public int enemyDefense;
    public int strength;
    public User player;
    public Enemies enemy;
    public Scanner userInput = new Scanner(System.in);
    public String spell;
    public Spells spells;


    public void useSpell() {
        boolean temp = true;
        mp = player.mp;
        enemyDefense = enemy.defense;
        while (temp) {
            System.out.println("Please write what spell or skill you want to use." +
            "\n" + "Or write skills to see available skills and spells.");
            spell = userInput.nextLine();
            if (spell.equals("skills")){
                spells.availableSpells();
                continue;
            }
            if (spell.equals("magicMissile")) {
                damage = spells.maggicMissile(mp, enemyDefense);
                break;
            }
            if (spell.equals("slash")){
                damage = spells.slash(player.strength,enemyDefense);
                break;
            }
            if (spell.equals("sneakAttack")) {
                damage = spells.sneakAttack(player.stamina,player.strength,enemyDefense);
                break;
            }


            if (damage == -1){
                System.out.println("You do not have enough MP or strength to use " + spell + "\n" +
                "You currently have " + mp + " MP");
                continue;
            }
        }
    }

}
