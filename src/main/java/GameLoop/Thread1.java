package GameLoop;
import player.Player;
import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread1 {
    public Player player;
    public void run()
    {
        System.out.println("Welcome to the game world, follow the instructions ahead.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = userInput.nextLine();
        System.out.println("Enter your race." + " You can pick orc, human, or elf");
        String Race = userInput.nextLine();
        System.out.println("Enter your class" + " You can pick warrior, mage, or thief");
        String Class = userInput.nextLine();
        this.player = new Player(name, Race, Class);


    }
    public Player getPlayer()
    {
        return player;
    }
}
