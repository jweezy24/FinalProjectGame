package Player;

public class Spells {
    public int damage;
    public int mpCost;
    public int critMod;

    public String availableSpells() {
        String skills;
        skills = "maggicMissile" + "\n" +
                 "slash" + "\n" +
                 "sneakAttack";
        return skills;
    }
    public int maggicMissile(int mp,int defense){
        mpCost = 3;
        if (mp<mpCost){
            return -1;
        }
        damage = 3;
        damage = damage -defense;

        return damage;
    }

    public int slash(int strength,int defense){
        if (strength<defense*10){
            return -1;
        }
        return strength-defense*10;
    }

    public int sneakAttack(int stamina, int strength, int defense){
        critMod = stamina/50;
        if (stamina<defense*25 && strength>defense*10){
            return strength-defense*10;
        }
        return strength*critMod;
    }
}
