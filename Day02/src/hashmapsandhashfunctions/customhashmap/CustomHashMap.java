package hashmapsandhashfunctions.customhashmap;

import java.util.LinkedList;
class CustomHashMap<K, V> {
    private static final int SIZE = 16; // Default capacity
    private LinkedList<Entry<K, V>>[] buckets;

    // Constructor to initialize the array of linked lists
    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to get bucket index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    // Retrieve value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // Remove key from the hash map
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return;
            }
        }
    }

    // Display the hash map
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

}