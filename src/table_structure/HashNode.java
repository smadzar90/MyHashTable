package table_structure;

//Author: Stipan Madzar

public class HashNode<K, V> {
    
    private HashNode<K, V> next; //Next node in the list
    private K key; 
    private V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //Check if next node is not null
    public boolean hasNext() {
        if(this.next != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public HashNode<K, V> getNext() {
        return this.next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

}
