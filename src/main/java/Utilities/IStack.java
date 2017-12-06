package Utilities;

/**
 * Created by jwest1 on 12/6/2017.
 */
import java.util.List;

/**
 * Generic interface for a last-in-first-out (LIFO) data structure where objects are inserted into
 * and removed from the same end.
 *
 * <p>Based on Koffman & Wolfgang, Data Structures 3rd ed, Wiley 2015.
 *
 * @param <E> The element type
 */
public interface IStack<E> {
    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @post The stack is one item larger and nonempty.
     * @param obj The object to be inserted
     * @return The object inserted
     */
    E push(E obj);

    /**
     * Returns the object at the top of the stack without removing it.
     *
     * @post The stack remains unchanged.
     * @return The object at the top of the stack
     * @throws java.util.NoSuchElementException if stack is empty
     */
    E peek();

    /**
     * Returns the object at the top of the stack and removes it.
     *
     * @post The stack is one item smaller.
     * @return The object at the top of the stack
     * @throws java.util.NoSuchElementException if stack is empty
     */
    E pop();

    /**
     * Returns true if the stack is empty; otherwise, returns false.
     *
     * @post The stack remains unchanged.
     * @return true (false) if the stack is empty (not empty)
     */
    boolean isEmpty();

    /**
     * Returns a Java list containing the items currently in the stack. The item at the top of the
     * stack is the first item of the list (at index 0).
     *
     * @post The stack remains unchanged.
     * @return The list containing the items in the stack
     */
    List<E> asList();

    /**
     * Returns a Java list containing the items currently in the stack. The item at the bottom of the
     * stack is the first item of the list (at index 0).
     *
     * @post The stack remains unchanged.
     * @return The list containing the items in the stack
     */
    List<E> asFifoList();
}