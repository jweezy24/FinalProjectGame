package Player;

import java.util.HashMap;
import java.util.Map;
import GameLoop.Item;
import Player.Player;
import java.util.Scanner;

/**
 * Created by pjackowski on 11/29/2017.
 */
public class Inventory {
    public int backpackSize = 10;
    public Map inv = new HashMap(backpackSize);
    public Map equipment = new HashMap(6);
    public Player player;
    public boolean backP;
    public Scanner input = new Scanner(System.in);



    public void addItem(Item item){
        for (int i = 0;i<inv.size();i++){
            if (backP = true){
                System.out.println("Backpack is full please pick an item to remove");
                removeItem();
            }
            if(inv.containsKey(i)){
                continue;
            }
            else if(!inv.containsKey(i)){
                this.inv.putIfAbsent(i,item);
            }
        }
    }

    public int removeItem(){
        System.out.println(toAString());
        String temp;
        temp = input.nextLine();
        int i = 0;
        return 0;
    }
    public String toAString(){
        String temp = " ";
        for (int i= 0; i<inv.size();i++){
            temp += inv.get(i) + " ";
        }
        return temp;
    }
    public void addEquipment(Item item){
        if(item.equipmentType.equals("helmet")){
            this.equipment.put(0,item);
            player.intellegence += item.intel;
            player.stamina += item.stamina;
            player.strength += item.strength;
        }
        if(item.equipmentType.equals("armor")){
            this.equipment.put(1,item);
            player.intellegence += item.intel;
            player.stamina += item.stamina;
            player.strength += item.strength;
        }
        if(item.equipmentType.equals("weapon")){
            this.equipment.put(2,item);
            player.intellegence += item.intel;
            player.stamina += item.stamina;
            player.strength += item.strength;
        }
        if(item.equipmentType.equals("legs")){
            this.equipment.put(3,item);
            player.intellegence += item.intel;
            player.stamina += item.stamina;
            player.strength += item.strength;
        }
        if(item.equipmentType.equals("boots")){
            this.equipment.put(4,item);
            player.intellegence += item.intel;
            player.stamina += item.stamina;
            player.strength += item.strength;
        }
        if(item.equipmentType.equals("backpack")){
            this.equipment.put(5,item);
            this.backpackSize = item.backpackSize;
        }

    }

}
