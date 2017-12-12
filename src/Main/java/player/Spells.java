package player;

public class Spells {
  public int damage;
  public int mpCost;
  public int critMod;

  public String availableSpells() {
    String skills;
    skills = "magicMissile" + "\n" + "slash" + "\n" + "sneakAttack";
    return skills;
  }

  public int maggicMissile(int mp, int defense, int intel) {
    mpCost = 3;
    if (mp < mpCost) {
      return -1;
    }
    damage = 10*(intel/9) - defense;
    return damage;
  }

  public int slash(int strength, int defense) {
    if (strength < defense) {
      return -1;
    }
    return strength+6 - defense;
  }

  public int sneakAttack(int stamina, int strength, int defense) {
    critMod = stamina / 50;
    if (stamina < defense * 25 && strength > defense * 10) {
      return strength - defense;
    }
    return strength * critMod;
  }
}
