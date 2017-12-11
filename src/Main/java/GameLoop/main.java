package GameLoop;

/** Created by jwest1 on 11/17/2017. */
public class main {
  public static void main(String args[]) {
    Loop loop = new Loop();
    Thread t = new Thread(loop);
    loop.creatingThreads(LoopLinks.thread1);
    t.run();

    Thread t2 = new Thread(loop);
    loop.creatingThreads(LoopLinks.thread2);
    t2.run();

    Thread t3 = new Thread(loop);
    loop.creatingThreads(LoopLinks.thread3);
    t3.run();
  }
}
