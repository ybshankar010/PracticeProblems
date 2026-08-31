package in.bhavanishankar;

import in.bhavanishankar.cache.LRUCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {
        IO.println("Implementing LRU Cache");
        LRUCache cache;
        List<Integer> allKeys = new ArrayList<>(10);
        try (Scanner sc = new Scanner(System.in)) {
            IO.println("Enter Capacity");
            int capacity = sc.nextInt();
            cache = new LRUCache(capacity);
            int key = -1, value;
            do {
                IO.println("Enter Key && Value :: ");
                key = sc.nextInt();
                value = sc.nextInt();
                cache.put(key, value);
                allKeys.add(key);
                if (allKeys.size()%capacity == 0) {
//                    int random = (int) (Math.random() * allKeys.size());
//                    int cachedValue = cache.get(allKeys.get(random));
                    IO.println("Get the key for retrieval :: ");
                    int random = sc.nextInt();
                    int cachedValue = cache.get(random);
                    IO.println("Key value for random key " + random + " Value " + cachedValue);
                }
//                IO.println("If you want to Stop, Enter -1 ");
//                key = sc.nextInt();
            } while (key != -1);
        }
    }
}
