package Utilities;

import GameLoop.Fail;

/**
 * Created by jwest1 on 12/6/2017.
 */
class Node<E> {
    public E data;
    public Node<E> next;
    public Fail fail;
    public Node(final E data, final Node<E> pass, final Fail fail) {
        if (data == null) throw new IllegalArgumentException("data is null");
        this.data = data;
        this.next = pass;
        this.fail = fail;
    }
    public Node(final E data) { this(data, null, null); }
    public String toString() {
        return "Node@" + hashCode() + "(" + data +
                (next != null ? ", Node@" + next.hashCode() + ")" : ") ") +
                (fail != null ? ", Node@" + fail.hashCode() + ")" : ")");
    }
}