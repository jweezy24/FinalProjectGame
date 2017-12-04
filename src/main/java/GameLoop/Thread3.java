package GameLoop;

import Player.Player;

import java.util.Scanner;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Thread3 {
    public Player user;
    public Thread3(Player player)
    {
        user = player;
    }

    public void run()
    {
        Scanner userInput = new Scanner(System.in);
        while(user.isAlive())
        {

        }
    }
}
