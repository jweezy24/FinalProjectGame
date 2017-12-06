package GameLoop;

import java.util.Scanner;

public class UserInput {
    public Scanner input = new Scanner(System.in);


    public String Scan()
    {
        String information = input.nextLine();
        if(information.equals("help"))
        {
            System.out.println("This is the help menu");
            return null;
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
