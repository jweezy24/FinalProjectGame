import GameLoop.Dungeon;
import GameLoop.Enemies;
import GameLoop.Town;
import GameLoop.WorldGeneration;
import org.junit.Test;
import static org.junit.Assert.*;

public class WorldTests {
    @Test
    public void testWorldGeneration()
    {
        WorldGeneration world = new WorldGeneration(0);
        assertNotNull(world);
        assertNotNull(world.event);
        assertEquals("dungeon",world.event.type);

    }
    @Test
    public void testEnemies()
    {
        Enemies enemies = new Enemies(1);
        assertNotNull(enemies);
        assertNotEquals(0,enemies.attack);
        assertNotEquals(0,enemies.health);
        assertTrue(enemies.alive);
    }
    @Test
    public void testDungeon()
    {

        Dungeon dungeon = new Dungeon(1);
        assertNotNull(dungeon);
        assertEquals(1,dungeon.DUNGEONLEVEL);
        assertEquals(10,dungeon.MAXROOMS);
    }
    @Test
    public void testTown()
    {
        Town town = new Town();
        assertNotNull(town);

    }
}
