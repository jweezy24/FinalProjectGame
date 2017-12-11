package GameLoop;

import java.util.Scanner;
import player.User;

public class UserInput {
  public Scanner input = new Scanner(System.in);
  public User player;

  public UserInput() {}

  public UserInput(User player) {
    this.player = player;
  }

  public String Scan() {
    String information = input.nextLine();
    if (information.equals("info")) {
      Display tempDisplay = new Display(player);
      System.out.println("Press any key to continue.");
      this.Scan();
      tempDisplay.frame.dispose();
    }
    return information;
  }

  public String[] levelUp()
  {
    String[] input = new String[2];
    String userInput = this.Scan();
    if(userInput.contains(" "))
    {
      input = userInput.split(" ");
    }else
      {
        while(!userInput.contains(" "))
        {
          System.out.println("Please enter what you choice as '(skill) (amount)'");
          userInput = this.Scan();
        }
      }


    return input;
  }

  public Integer numberScan() {
    Integer num;
    String info = input.nextLine();
    try {
      num = Integer.parseInt(info);
      return num;
    } catch (NumberFormatException e) {
      System.out.println("That is not a number, please try again");
    }
    return null;
  }

  public Integer numberScan(String special) {
    Integer num;
    String info = input.nextLine();
    try {
      num = Integer.parseInt(info);
      return num;
    } catch (NumberFormatException e) {
      if (info.equals(special)) {
        return 100000;
      }
      System.out.println("That is not a number, please try again");
    }

    return null;
  }

  public String[] playerGeneration()
  {
    String[] returns = new String[3];
    System.out.println("Welcome to the game world, follow the instructions ahead.");
    Scanner userInput = new Scanner(System.in);
    System.out.println("Enter your name");
    String name = userInput.nextLine();
    returns[0] = name;

    System.out.println("Enter your race." + " You can pick orc, human, or elf");
    String Race = userInput.nextLine();
    if(Race.toLowerCase().equals("orc")||Race.toLowerCase().equals("human")||Race.toLowerCase().equals("elf"))
    {
      returns[1] = Race;
    }else{
      while(!(Race.toLowerCase().equals("orc")||Race.toLowerCase().equals("human")||Race.toLowerCase().equals("elf"))) {
        System.out.println("Please enter either, human, orc, or elf.");
        Race = input.nextLine();
      }
      returns[1] = Race;
    }

    System.out.println("Enter your class" + " You can pick warrior, mage, or thief");
    String Class = userInput.nextLine();
    if(Class.toLowerCase().equals("mage")||Class.toLowerCase().equals("thief")||Class.toLowerCase().equals("warrior"))
    {
      returns[2] = Class;
    }else {
      while (!(Class.toLowerCase().equals("mage") || Class.toLowerCase().equals("thief") || Class.toLowerCase().equals("warrior"))) {
        System.out.println("Please enter either, mage, thief, or warrior.");
        Class = input.nextLine();
      }
      returns[1] = Class;
    }

    return returns;
  }
}
