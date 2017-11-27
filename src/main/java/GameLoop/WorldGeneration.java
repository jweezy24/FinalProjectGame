package GameLoop;

/**
 * Created by jwest1 on 11/27/2017.
 */

public class WorldGeneration
{
    public final int MAXEVENTS = 20;
    public WorldGeneration()
    {

    }

}

class Node<E> {
    public E data;
    public Node<E> pass;
    public Node<E> fail;
    public Node(final E data, final Node<E> pass, final Node<E> fail) {
        if (data == null) throw new IllegalArgumentException("data is null");
        this.data = data;
        this.pass = pass;
        this.fail = fail;
    }
    public Node(final E data) { this(data, null, null); }
    public String toString() {
        return "Node@" + hashCode() + "(" + data +
                (pass != null ? ", Node@" + pass.hashCode() + ")" : ") ") +
                (fail != null ? ", Node@" + fail.hashCode() + ")" : ")");
    }
}
