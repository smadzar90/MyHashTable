package table_structure;

//Author: Stipan Madzar

public class TestMyHashTable {
    

    public static void main(String[] args) {


        MyHashTable<Integer, Integer> myTable = new MyHashTable<>(); //Creating HashTable with default capacity
        myTable.put(20, 5); //Inserting element
        myTable.put(20, 54);
        myTable.put(32, 23);
        myTable.put(1, 55);
        myTable.put(14, 1);
        myTable.remove(1); //Removing element
        myTable.remove(4);
        System.out.println(myTable.getSize()); //Returning the number of added elements
        System.out.println(myTable.get(14)); //Returning the value of the specific key
        System.out.println(myTable.get(20));
        myTable.clearTable(); //Clear the table
        System.out.println(myTable.getSize());  

    }
}
