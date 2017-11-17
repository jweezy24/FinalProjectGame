package GameLoop;

/**
 * Created by jwest1 on 11/17/2017.
 */

public class main {
    public static void main(String args[])
    {
        Thread t = new Thread(new Loop(LoopLinks.thread1));
        t.start();
    }
}


