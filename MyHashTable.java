
/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Josh Lewis
 * @version March 12, 2019
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V>
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    private int capacity;
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
        table = new ArrayList<>();
        count = 0;
        capacity = tableSize;
        for (int i = 0; i < tableSize; i++) {  // make empty hash entries
            table.add(null);
        }
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
        table = new ArrayList<>();
        count = 0;
        new MyHashTable<>(10);
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
        return count;
    }
    
    /**
     * clear the table
     */
    public void clear(){
        for(int i = 0; i < table.size(); i++){
            table.add(null);
        }
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        MyHashEntry<K, V> head = table.get(index); // search for key
        while (head != null) {
            if (head.getKey().equals(key))
                return head.getValue();
            head = head.next;
        }
        return null; // return NULL if not found
    }
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        MyHashEntry<K, V> head = table.get(index);
        // Check if key is already present
        while (head != null) {
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            }
            head = head.next;
        }
        count++;
        head = table.get(index);
        MyHashEntry<K, V> newNode = new MyHashEntry<K, V>(key, value);
        newNode.next = head;
        table.set(index, newNode);
        
        // If load factor goes beyond threshold, then double the hash table size
        if ((1.0 * count) / capacity >= 0.7) {
            ArrayList<MyHashEntry<K, V>> temporary = table;
            table = new ArrayList<>();
            capacity = 2 * capacity;
            count = 0;
            for (int i = 0; i < capacity; i++)
                table.add(null);
            for (MyHashEntry<K, V> headNode : temporary) {
                while (headNode != null) {
                    insert(headNode.getKey(), headNode.getValue());
                    headNode = headNode.next;
                }
            }
        }
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        int hashcode = key.hashCode(); // Apply hash function to find index
        int index = hashcode % capacity;
        MyHashEntry<K, V> head = table.get(index); // Get head of chain

        MyHashEntry<K, V> pre = null; // Search for key in its HashEntry
        while (head != null) {
            // If Key found
            if (head.getKey().equals(key))
                break;
            // Else keep moving in HasEntry
            pre = head;
            head = head.next;
        }
        
        // If key was not there
        if (head == null)
            return null;
        
        // Reduce the size
        count--;
        
        // Remove the key
        if (pre != null)
            pre.next = head.next;
        else
            table.set(index, head.next);
        
        return head.getValue();
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        return count == 0;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString(){
        String output = " ";
        for(int i = 0; i<capacity;i++) {
            MyHashEntry<K, V> entry = table.get(i);
            if(entry != null) {
                output += "[" + entry.getKey() + "," + entry.getValue() + "]";
            }
        }
        return output;
    }
}
