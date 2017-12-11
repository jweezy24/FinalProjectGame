package GameLoop;

import java.util.ArrayList;
import java.util.List;

public class EventList<E> {
  public final List<Node<E>> events = new ArrayList<>();
  public Fail failEvent = new Fail();

  public EventList() {}

  public void add(E data) {
    Node<E> tempNode = new Node<E>(data);
    events.add(tempNode);
    update();
  }

  public void update() {
    if (events.size() > 0) {
      for (int i = 0; i < events.size(); i++) {
        if (i < events.size() - 2) events.get(i).pass = events.get(i + 1);
        events.get(i).fail = failEvent;
      }
    }
  }
}

class Node<E> {
  public E data;
  public Node<E> pass;
  public Fail fail;

  public Node(final E data, final Node<E> pass, final Fail fail) {
    if (data == null) throw new IllegalArgumentException("data is null");
    this.data = data;
    this.pass = pass;
    this.fail = fail;
  }

  public Node(final E data) {
    this(data, null, null);
  }

  public String toString() {
    return "Node@"
        + hashCode()
        + "("
        + data
        + (pass != null ? ", Node@" + pass.hashCode() + ")" : ") ")
        + (fail != null ? ", Node@" + fail.hashCode() + ")" : ")");
  }
}
