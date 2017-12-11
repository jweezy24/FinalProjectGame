package GameLoop;

import player.User;

/** Created by jwest1 on 11/17/2017. */
public class Thread3 {
  public User user;
  public WorldGeneration world;

  public Thread3(User player, WorldGeneration world) {
    user = player;
    this.world = world;
  }

  public void run() {
    UserInput userInput = new UserInput(user);
    Narrator narrator = new Narrator();
    String choice = "";
    int dungeonCount =0;
    while (user.isAlive()) {
      narrator.newEvent(world.event);
      System.out.println(world.event.type);
      if (world.event.type.toLowerCase().equals("dungeon")) {
        dungeonCount +=1;
        if(dungeonCount >= 6)
        {
          System.out.println("You have completed the game!");
          break;
        }
        for (int i = 0; i < world.event.dungeon.rooms.size(); i++) {
          // System.out.println("Here");

          Room currentRoom = world.event.dungeon.getRoom(i);
          narrator.RoomInfo(currentRoom, i);
          currentRoom.playerInRoom(user, narrator);
          if (user.hp <= 0) {
            break;
          }
        }
      }
      if (world.event.type.toLowerCase().equals("town")) {
        world.event.town.playerInTown(user);
      }

      world = new WorldGeneration(user.level);
    }

    new Display("death");
    System.out.println("Press any key to exit.");
    System.exit(1);
  }
}
