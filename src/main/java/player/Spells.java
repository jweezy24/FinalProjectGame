package player;

import GameLoop.Enemies;

public class Spells {
    public int damage;
    public int mpCost;

    public int maggicMissile(int mp,int defense){
        mpCost = 3;
        if (mp<mpCost){
            return -1;
        }
        damage = 3;
        damage = damage -defense;

        return damage;
    }
}
