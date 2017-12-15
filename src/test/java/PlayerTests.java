import GameLoop.Enemies;
import org.junit.Test;
import player.Spells;
import player.Inventory;
import player.User;
import GameLoop.Fight;
import static org.junit.Assert.*;
import GameLoop.Item;

public class PlayerTests {
    @Test
    public void testUserGen(){
    User user = new User("Jade", "orc", "warrior");
    User user2 = new User("Champagne", "elf", "mage");
    User user3 = new User("Lorraine", "human", "thief");
    assertEquals("champagne", user2.name);
    assertEquals("lorraine", user3.name);
    assertEquals("elf", user2.race);
    assertEquals("human", user3.race);
    assertEquals("mage", user2.type);
    assertEquals("thief", user3.type);
    assertEquals("jade", user.name);
    assertEquals("orc", user.race);
    assertEquals("warrior", user.type);
    assertNotNull(user.strength);
    assertNotNull(user.stamina);
    assertNotNull(user.intellegence);
    assertNotNull(user.hp);
    assertNotNull(user.mp);
    assertNotNull(user.hpMax);
    assertNotNull(user.mpMax);
    assertNotNull(user2.strength);
    assertNotNull(user2.stamina);
    assertNotNull(user2.intellegence);
    assertNotNull(user2.hp);
    assertNotNull(user2.mp);
    assertNotNull(user2.hpMax);
    assertNotNull(user2.mpMax);
    assertNotNull(user3.strength);
    assertNotNull(user3.stamina);
    assertNotNull(user3.intellegence);
    assertNotNull(user3.hp);
    assertNotNull(user3.mp);
    assertNotNull(user3.hpMax);
    assertNotNull(user3.mpMax);
    }
    @Test
    public void testXp(){
        User user = new User("test","human", "mage");
        user.addXP(1);
        assertEquals(1,user.XP);
    }
    @Test
    public void testisAlive(){
        User user = new User("test","human", "mage");
        assertTrue(user.isAlive());
    }
    @Test
    public void testInventory(){
        User user = new User("test","human", "mage");
        Inventory inventory = new Inventory(user);
        assertEquals(10, inventory.backpackSize);
        assertTrue(inventory.inv.isEmpty());
        assertTrue(inventory.equipment.isEmpty());
        Item item = new Item(1);
        Item item2 = new Item(1);
        inventory.addItem(item);
        inventory.addItem(item2);
        inventory.addEquipment(item);
        assertEquals(1,inventory.equipment.size());
    }
    @Test
    public void testSpells(){
        Spells spells = new Spells();
        assertEquals("magicMissile" + "\n" + "slash" + "\n" + "sneakAttack", spells.availableSpells());
        assertNotNull(spells.magicMissile(3,1,10));
        assertNotNull(spells.slash(10,1));
        assertNotNull(spells.sneakAttack(10,10,1));
    }
    @Test
    public void testFight(){
        User user = new User("test","human", "mage");
        Enemies enemy = new Enemies(1);
        Fight fight = new Fight(user);
        fight.setEnemy(enemy);
        assertNotNull(fight.enemyDefense);
    }
}
