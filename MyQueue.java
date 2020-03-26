/**
 * class MyQueue implemented using ArrayList. The index 0 element is the front of the queue
 * The last element of the queue has index tail
 * @author Josh Lewis
 * @version 2/28/2019
 */
import java.util.ArrayList;

public class MyQueue<E>
{
    private ArrayList<E> list; // hold the elements in queue
    private int tail; // index of the last element in queue
    
    /**
     * constructor construct an empty queue
     */
    public MyQueue()
    {
    }
    
    /**
     * isEmpty return true if the queue is empty; false otherwise
     * @return true if the queue is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return list.size() == 0;
    }
    
    /**
     * size return the size of the queue
     * @return the number of elements in queue
     */
    public int size()
    {
        return list.size();
    }
    
    /**
     * peek return the front element of the queue
     * @return the front element of the queue. If the queue is empty, return null
     */
    public E peek()
    {
        if(!isEmpty())
            return list.get(0);
        else
            return null;
    }
    
    /**
     * pop remove the front element of the queue
     */
    public void pop()
    {
        list.remove(0);
    }
    
    /**
     * push push a new element to the queue
     */
    public void push(E item)
    {
        list.add(item);
        tail++;
    }
}
