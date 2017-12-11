package GameLoop;

import java.util.Scanner;
import player.Spells;
import player.User;

// this might need to be moved to thread

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

  public Fight(User player) {
    this.player = player;
    this.spells = new Spells();
  }

  public void setEnemy(Enemies enemy) {
    this.enemy = enemy;
  }

  public int useSpell(String charClass) {
    boolean temp = true;
    mp = player.mp;
    enemyDefense = enemy.defense;
    while (temp) {
      System.out.println(
          "Please write what spell or skill you want to use."
              + "\n"
              + "Or write skills to see available skills and spells.");
      spell = userInput.nextLine();
      System.out.println(spell);
      if (spell.toLowerCase().equals("skills")) {
        System.out.println(spells.availableSpells());
        continue;
      }
      if (spell.equals("magicMissile")) {
        damage = spells.maggicMissile(mp, enemyDefense);
        break;
      }
      if (spell.equals("slash")) {
        damage = spells.slash(player.strength, enemyDefense);
        break;
      }
      if (spell.equals("sneakAttack")) {
        damage = spells.sneakAttack(player.stamina, player.strength, enemyDefense);
        break;
      }

      if (damage == -1) {
        System.out.println(
            "You do not have enough MP or strength to use "
                + spell
                + "\n"
                + "You currently have "
                + mp
                + " MP");
        continue;
      }
    }
    return damage;
  }
}
