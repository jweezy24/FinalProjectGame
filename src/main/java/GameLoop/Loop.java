package GameLoop;
import java.lang.Thread;

/**
 * Created by jwest1 on 11/17/2017.
 */
public class Loop extends Thread{
    public Thread1 thread1;
    public Thread2 thread2;
    public Thread3 thread3;


    public Loop(LoopLinks thread)
    {
        switch(thread){
            case thread1:
                this.run("Thread 1");
                new Thread1().run();

        }

    }
    public void run(String thread)
    {
        System.out.println("Running " + thread);
    }
}
