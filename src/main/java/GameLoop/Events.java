package GameLoop;
import java.util.Random;
/**
 * Created by jwest1 on 11/27/2017.
 */
public class Events {
    public Events()
    {
        generateEvents();
    }
    public void generateEvents()
    {
        Random event = new Random(3);
        int generation = event.nextInt();
        if(generation == 1)
        {

        }
    }
}
