package GameLoop;
import player.Player;

import java.lang.Thread;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Loop extends Thread{
    public Thread1 thread1;
    public Thread2 thread2;
    public Thread3 thread3;
    public Player player;
    public WorldGeneration world;


    public Loop()
    {

    }
    public void creatingThreads(LoopLinks thread)
    {
        switch(thread){
            case thread1:
                this.run("Thread 1");
                thread1 = new Thread1();
                thread1.run();
                player = thread1.getPlayer();
                System.out.println(player);
                break;
            case thread2:
                this.run("Thread 2");
                thread2 = new Thread2(player.level);
                thread2.run();
                world = thread2.getWorld();
                System.out.println(world);
                break;
            case thread3:




        }
    }
    public void run(String thread)
    {
        System.out.println("Running " + thread);
    }
}
