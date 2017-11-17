package GameLoop;

import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread1 {
    public void run()
    {
        System.out.println("Welcome to the game world, follow the instructions ahead.");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = userInput.nextLine();
        System.out.println("Enter your race");
        String Race = userInput.nextLine();
        System.out.println("Enter your class");
        String Class = userInput.nextLine();
    }
}
