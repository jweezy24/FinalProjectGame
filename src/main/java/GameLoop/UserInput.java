package GameLoop;

import player.User;

import java.util.Scanner;

public class UserInput {
    public Scanner input = new Scanner(System.in);
    public User player;

    public UserInput()
    {

    }

    public UserInput(User player)
    {
        this.player = player;
    }

    public String Scan()
    {
        String information = input.nextLine();
        if(information.equals("info"))
        {
            System.out.println("Your Character.");
            new Display(player);
            this.Scan();
        }
        return information;
    }
    public Integer numberScan()
    {
        Integer num;
        String info = input.nextLine();
        try
        {
            num = Integer.parseInt(info);
            return num;
        }catch (NumberFormatException e)
        {
            System.out.println("That is not a number, please try again");
        }
        return null;
    }
    public Integer numberScan(String special)
    {
        Integer num;
        String info = input.nextLine();
        try
        {
            num = Integer.parseInt(info);
            return num;
        }catch (NumberFormatException e)
        {
            if(info.equals(special))
            {
                return 100000;
            }
            System.out.println("That is not a number, please try again");
        }

        return null;
    }
}
