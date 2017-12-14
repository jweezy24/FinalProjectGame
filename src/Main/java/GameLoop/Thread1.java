package GameLoop;

import player.User;

/** Created by jwest1 on 11/17/2017. */
public class Thread1 {
  public User player;

  public void run() {
    UserInput input = new UserInput();
    String[] value = input.playerGeneration();
    this.player = new User(value[0], value[1], value[2]);
  }

  public User getPlayer() {
    return player;
  }
}
