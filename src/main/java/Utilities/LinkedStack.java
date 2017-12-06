package Utilities;

/**
 * Created by jwest1 on 12/6/2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements IStack<E> {

    /** The topmost node of this stack. The stack gets pushed down from here. */
    private Node<E> top;

    private int size = 0;

    @Override
    public E push(final E obj) {
        Node<E> tempNode = top;
        top = new Node<>(obj);
        top.next = tempNode;

        return obj;
    }

    @Override
    public E peek() {
        if (top != null) {
            return top.data;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E pop() {
        if (top != null && size < 1) {
            Node<E> tempNode = top;
            top = top.next;

            return tempNode.data;
        } else throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        if (top == null && size < 1) return true;

        return false;
    }

    @Override
    public List<E> asList() {
        // TODO implement using an ArrayList preallocated with the right size
        // TODO add any instance variable(s) required to support this
        List<E> list = new ArrayList<E>();
        System.out.println(iter(top, list));

        return list;
    }

    private void populateList(final Node<E> curr, final List<E> result) {
        // TODO recursively populate the list in the desired order
        result.add(0, ((E) curr.data));
        if (curr.next != null) populateList(curr.next, result);
    }

    @Override
    public List<E> asFifoList() {
        final ArrayList<E> result = new ArrayList<>(size);
        if (top != null) populateFifoList(top, result); // TODO replace null with the right reference
        return result;
    }

    private void populateFifoList(final Node<E> curr, final List<E> result) {
        // TODO recursively populate the list in the desired orde
        result.add((E) curr.data);
        populateList(curr.next, result);
    }

    <E> List<E> iter(Node<E> top, List<E> list) {
        if (top != null) {
            list.add(top.data);
            if (top.next != null) iter(top.next, list);
        }
        return list;
    }
}
