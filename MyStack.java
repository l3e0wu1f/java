/**
 * class MyStack: A stack class implemented by using ArrayList
 * All stack elements are stored in an ArrayList. The top element
 * has index top
 * 
 * @author Josh Lewis
 * @version 2/28/2019
 */
import java.util.ArrayList;

public class MyStack<E>
{
    private ArrayList<E> list; // used to store elements in stack
    private int top = 0; // the index of top element
    
    /**
     * constructor construct an empty stack
     */
    public MyStack()
    {
    }
    
    /**
     * push a given element on the top of the stack
     */
    public void push(E item)
    {
        list.set(1, list.get(0)); // moves the top item to index 1
        list.set(0, item); // sets new item to top index
    }
    
    /**
     * isEmpty return true if the stack is empty; false otherwise
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return list.get(0) == null;
    }
    
    /**
     * peek Return the top element
     */
    public E peek()
    {
        return list.get(top);
    }
    
    /**
     * pop Remove the top element from the stack. If the stack is empty, nothing happen
     */
    public void pop()
    {
        if(list.size() > 0)
            list.remove(0);
    }
    
    /**
     * size return the size of the stack
     * @return number of elements in stack
     */
    public int size()
    {
        return list.size();
    }
}
