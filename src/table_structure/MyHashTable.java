package table_structure;

import java.util.ArrayList;

//Author: Stipan Madzar

public class MyHashTable<K, V> {

    private ArrayList<HashNode<K, V>> buckets; //slots to store elements in the table
    private int capacity;  //number of buckets in the HashTable
    private int size;  //number of elements in the HashTable

    public MyHashTable() {
        this(20);  // Default capacity -> 20
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<HashNode<K, V>>();
        initializeList(buckets, capacity);
        this.size = 0;
    }

    private void initializeList(ArrayList<HashNode<K, V>> buckets, int capacity) {
        for(int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }

    //Calculate bucket index
    private int getBucketsIndex(K key) {
        int hc = Math.abs(key.hashCode());
        return (hc % capacity);
    }

    //Return the capacity of HashTable
    public int getCapacity() {
        return this.capacity;
    }

    //Return the number of elements
    public int getSize() {
        return this.size;
    }
    
    //Insert the element in the HashTable
    public void put(K key, V value) {

      int index = getBucketsIndex(key);
      
      if(buckets.get(index) == null) {
         HashNode<K, V> newNode = new HashNode<K, V>(key, value);
         buckets.set(index, newNode);
         size++;
         return;
      }
      else {
        HashNode<K, V> curr = buckets.get(index);

        while(curr != null) {
            //Check if it has the same key
            //Replace the value if true
            if(curr.getKey().equals(key)) {
                curr.setValue(value);
                return;
            }
            if(!curr.hasNext()) {
                break;
            }
            curr = curr.getNext();
        }
        curr.setNext(new HashNode<K, V>(key, value));
        size++;
      }
    }

    //Get the value from the HashTable
    //Return null if not found
    public V get(K key) {

        int index = getBucketsIndex(key);
        HashNode<K, V> curr = buckets.get(index);

        if(curr == null) {
            return null;
        }

        while(curr != null) {
            if(curr.getKey().equals(key)) {
                return curr.getValue();
            }
            curr = curr.getNext();
        }
        return null;
    }

    //Remove the element from the HashTable
    public void remove(K key) {
        int index = getBucketsIndex(key);
        HashNode<K, V> toRemove = buckets.get(index);
        HashNode<K, V> prev = null;

        if(toRemove == null) {
            return;
        }

        while(toRemove != null) {
            if(toRemove.getKey().equals(key)) {
                break;
            }
            prev = toRemove;

            if(toRemove.hasNext()) {
                toRemove = toRemove.getNext();
            }
        }

        if(prev == null) {
            buckets.set(index, toRemove.getNext());
        }
        else {
            prev.setNext(toRemove.getNext());
        }
        size--;
    }

    //Set all buckets to null
    public void clearTable() {
        
        for(int i = 0; i < buckets.size(); ++i) {
            buckets.set(i, null);
        }
        size = 0;
    }
}

