package player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pjackowski on 11/29/2017.
 */
public class Inventory {
    public int backpackSize = 10;
    public Map inv = new HashMap(backpackSize);


    public void addItem(Object item){
        for (int i = 0;i<inv.size();i++){
            if(inv.containsKey(i)){
                continue;
            }
            else if(!inv.containsKey(i)){
                inv.putIfAbsent(i,item);
            }
        }
    }

}
