package GameLoop;

/** Created by jwest1 on 11/17/2017. */
public class Thread2 {
  public WorldGeneration world;
  public int level;

  public Thread2(int level) {
    this.level = level;
  }

  public void run() {
    world = new WorldGeneration(this.level);
  }

  public WorldGeneration getWorld() {
    return world;
  }
}
