package GameLoop;
import player.User;
import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread1 {
    public User player;
    public Display display;
    public void run()
    {
        System.out.println("Welcome to the game world, follow the instructions ahead.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = userInput.nextLine();
        System.out.println("Enter your race." + " You can pick orc, human, or elf");
        String Race = userInput.nextLine();
        System.out.println("Enter your class" + " You can pick warrior, mage, or thief");
        display = new Display("start");
        String Class = userInput.nextLine();
        this.player = new User(name, Race, Class);


    }
    public User getPlayer()
    {
        return player;
    }
}
