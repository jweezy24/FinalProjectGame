package GameLoop;
import player.User;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Display extends JFrame{
    public JFrame frame;

    public ImageIcon image = new ImageIcon("src/main/java/GameLoop/Menus/largeChooseChar.png");
    public ImageIcon death = new ImageIcon("src/main/java/GameLoop/Menus/deathScreenLarge.png");
    public ImageIcon warrior = new ImageIcon("src/main/java/GameLoop/Menus/2warriorFight.png");
    public ImageIcon mage = new ImageIcon("src/main/java/GameLoop/Menus/1WizadFight.png");
    public ImageIcon theif = new ImageIcon("src/main/java/GameLoop/Menus/0rogueFight.png");
    public Display(String screen)
    {




        if(screen.equals("start"))
        {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("", image, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(image.getIconWidth(),image.getIconHeight());
            panel.setBackground(Color.CYAN);

            frame.add(panel);

            panel.add(label);
            System.out.println("Before Thread");

            frame.getContentPane().add(panel);
            Thread d = new Thread(new ShowImages(frame));
            d.run();

        }
        if(screen.equals("death"))
        {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("", death, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(death.getIconWidth(),death.getIconHeight());
            panel.setBackground(Color.CYAN);

            frame.add(panel);

            panel.add(label);
            System.out.println("Before Thread");

            frame.getContentPane().add(panel);
            Thread d = new Thread(new ShowImages(frame));
            d.run();

        }

    }

    public Display(User player)
    {
        String text = player.toString().replace("\n","<br>");

        if(player.type.equals("warrior")) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("", warrior, JLabel.CENTER);
            label.setText("<html>"+ text +"</html>");
            JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(warrior.getIconWidth()+50, warrior.getIconHeight()+50);
            panel.setBackground(Color.CYAN);


            frame.add(panel);

            panel.add(label);
            System.out.println("Before Thread");

            frame.getContentPane().add(panel);
            Thread d = new Thread(new ShowImages(frame));
            d.run();
        }
        if(player.type.equals("mage")) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("", mage, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(mage.getIconWidth(), mage.getIconHeight());
            panel.setBackground(Color.CYAN);
            label.setText("<html>"+ text +"</html>");

            frame.add(panel);

            panel.add(label);
            System.out.println("Before Thread");

            frame.getContentPane().add(panel);
            Thread d = new Thread(new ShowImages(frame));
            d.run();
        }
        if(player.type.equals("thief")) {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JLabel label = new JLabel("", theif, JLabel.CENTER);
            JPanel panel = new JPanel(new BorderLayout());
            panel.setSize(theif.getIconWidth(), theif.getIconHeight());
            panel.setBackground(Color.CYAN);
            label.setText("<html>"+ text +"</html>");
            frame.add(panel);

            panel.add(label);
            System.out.println("Before Thread");

            frame.getContentPane().add(panel);
            Thread d = new Thread(new ShowImages(frame));
            d.run();
        }
    }


}

class ShowImages extends Thread
{
    public JFrame frame;
    public ShowImages(JFrame frame)
    {
        this.frame = frame;
    }
    public void run()
    {

        frame.pack();
        frame.setVisible(true);

    }
}
