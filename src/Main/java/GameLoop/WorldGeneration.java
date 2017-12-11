package GameLoop;

/** Created by jwest1 on 11/27/2017. */
public class WorldGeneration {
  public final int MAXEVENTS = 20;
  public Events event;

  public WorldGeneration(int level) {
    event = new Events(level);
  }

  public String toString() {
    String message = event.toString();
    return "The current event is " + message;
  }
}
