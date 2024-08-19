/**
 * class MyHashTable. A simple HashTable. Handle collision by chain
 * 
 * @author Hongbiao Zeng
 * @version Nov 27, 2015
 */
import java.util.ArrayList;

public class MyHashTable<K extends Comparable<K>, V> extends CSCI251ProjThree
{
    private ArrayList<MyHashEntry<K, V>> table;
    private int count; // how many elements in table
    private final int sizeOfTable; //How big the table is. This is a const value as the table does not increase in size.
    
    /**
     * Constructor. Constructor an empty MyHashTable with given number of Buckets
     * @param tableSize The number of Buckets of the table
     */
    public MyHashTable(int tableSize){
       this.table = new ArrayList(tableSize); //Creates a new table with tableSize buckets.
       this.count = 0; //Count is set to zero; there are no elements currently in the table.
       this.sizeOfTable = tableSize;
       for(int i = 0; i < tableSize; i++)
       {
           this.table.add(null);
       }
    }
    
    /**
     * constructor. Construct an empty MyHashTable with capacity 10 buckets
     */
    public MyHashTable(){
       table = new ArrayList(10); //Creates a new table with 10 buckets.
       count = 0; //Count is set to zero; there are no elements currently in the table.
       this.sizeOfTable = 10; //The table has a size of 10.
       for(int i = 0; i < this.sizeOfTable; i++)
       {
           this.table.add(null);
       }
    }
    
    /**
     * get the number of elements in the table
     * @return the number of elements in the table
     */
    public int size(){
       return this.count; //Returns the number of elements that are currently in the table.
    }
    
    /**
     * clear the table
     */
    public void clear(){
       for(int i = 0; i < this.sizeOfTable; i++)
       { //Sets every value to null; aka, clearing the table.
           this.table.set(i, null); 
       }
    }
    
    /**
     * get the value with given key.
     * @param key The given key
     * @return the value that have the key matches the given key. If no such a value, return null
     */
    public V get(K key){
       int b = key.hashCode();
       int index = b % this.sizeOfTable;
       
       if(index < 0)
       {
           index += this.sizeOfTable;
       }
       
       if(this.table.get(index) == null)
       { //If the table has no entries, move on
             
       }
       else
       { //If the table does have entries for this particular index:
           if(this.table.get(index).getKey().compareTo(key) == 0)
           { //If the first entry for this particular bucket has the same key:
               return this.table.get(index).getValue();     
           }
           else
           {
               MyHashEntry<K, V> a = this.table.get(index).getNext();
               while(a != null && a.getKey().compareTo(key) != 0)
               {
                   if(a.getKey() == key)
                   { //If this particular entry has the same key:
                       return a.getValue();
                   }
                   a = a.getNext();
               }
           }
       }
       return null;
    }
    
    
    /**
     * insert (key, value) pair into the table
     * @param key The key of the pair
     * @param value The value of the pair
     */
    public void insert(K key, V value){
        this.count++; //Since a key and value are being inserted, then that means there is one more element in the array. 
        MyHashEntry<K, V> a = new MyHashEntry(key, value); //Creates a new hash entry.

        int b = key.hashCode();
        int index = b % this.sizeOfTable; 
       
        if(this.table.get(index) == null)
        { //If the table has no elements at the index, then the new has entry is merely added to it.
            this.table.set(index, a);
        }
        
        if(index < 0)
        {
            index += this.sizeOfTable;
        }
        
        MyHashEntry<K, V> d = (MyHashEntry)this.table.get(index);
        
        while(d.getNext() != null && d.getKey().compareTo(key) != 0)
        { //Loops through the hash entries for index __.
            d = d.getNext(); 
        }
        
        if(d.getKey().compareTo(key) == 0)
        {
            d.setValue(value);
        }
        else
        {
            d.setNext(new MyHashEntry(key, value));
        }
        
        System.out.println("The key has a hash code of " + b + " and located in bucket " + index);
        
        //USED TO TEST AND MAKE SURE ENTRIES WERE ENTERED INTO THE RIGHT BUCKETS IN THE CORRECT ORDER.
        //int g = this.sizeOfTable; //Loop counter.
        // int i = 0; //Index.
        // boolean bucketIsEmpty;
        // MyHashEntry<K, V> e; 
        // while(g > 0)
        // {   
            // bucketIsEmpty = true;
            // e = (MyHashEntry)this.table.get(i);
            // System.out.print("The item(s) in index " + i + " is: ");
            // while(e != null)
            // { //Loops through the has entries for i.
                // if(e.getNext() != null)
                // {
                    // System.out.print(e.getValue() + ", ");
                // }
                // else
                // {
                    // System.out.print(e.getValue() + ".");
                // }
                // e = e.getNext();
                // bucketIsEmpty = false;
            // }
            // if(bucketIsEmpty)
            // {
                // System.out.print("Empty");
            // }
            // System.out.println();
            // g--;
            // i++;
        // }
    }
    
    /**
     * remove the value with given key from the table
     * @param key The given key
     * @return the value whose key matches the given key. If no such value, null is returned
     */
    public V remove(K key){
        //Finds the hash for the corresonding key. Then calculates what index it should be placed in.
        int b = key.hashCode();
        int index = b % this.sizeOfTable;
        
        if(this.table.get(index) == null)
        { //If this particular bucket is empty, then null is returned.
            return null;
        }
        
        if(index < 0)
        {
            index += this.sizeOfTable;
        }
        
        if(this.table.get(index).getKey().compareTo(key) == 0)
        { //If the first entry in this particular bucket contains the key that the user is searching for:
            MyHashEntry<K, V> e = (MyHashEntry)this.table.get(index);
            V keyBeingRemoved = e.getValue();

            this.table.set(index, e.getNext());
            
            this.count--;
            
            return keyBeingRemoved; //Returns the value of the key that is getting removed.
        }
        
        MyHashEntry<K, V> e = (MyHashEntry)this.table.get(index).getNext();
        if(e.getKey() == null || e.getValue() == null)
        {//If the next entry is empty
            return null;
        }
        
        while(e.getKey().compareTo(key) != 0 && e.getKey() != null)
        { 
            e = e.getNext();   
        }
            
        if(e.getKey().compareTo(key) != 0)
        { //If the entries have all gone through and no matching key has been found, then null is returned.
            return null;
        }
        
        V x = e.getValue(); //"Saves" the value of e, so that it can be returned after removal.
        K a;
        V c;
        
        this.table.get(index).setNext(e.getNext());
        this.count--;
        return x; //Returns the value of the key that is getting removed.
    }
    
    /**
     * check if the table is empty,i.e. no entry
     * @return true if the table holds no elements; false otherwise
     */
    public boolean isEmpty(){
        if(table.isEmpty())
        {
            return true;
        }
        return false;
    }
    
    /**
     * return a String representation of the table
     * @return a String representation of the table
     */
    public String toString(){
        int g = this.sizeOfTable; //Loop counter.
        int i = 0; //Index.
        boolean bucketIsEmpty;
        String a = "";
        MyHashEntry<K, V> e; 
        while(g > 0)
        {   
            bucketIsEmpty = true;
            e = (MyHashEntry)this.table.get(i);
            a += ("The item(s) in index " + i + " is: ");
            while(e != null)
            { //Loops through the has entries for i.
                if(e.getNext() != null)
                {
                    a += (e.getValue() + ", ");
                }
                else
                {
                    a += (e.getValue() + ".");
                }
                e = e.getNext();
                bucketIsEmpty = false;
            }
            
            
            if(bucketIsEmpty)
            {
                a += ("Empty");
            }
            a += ("\n");
            g--;
            i++;
        }
        return a;
    }
}
