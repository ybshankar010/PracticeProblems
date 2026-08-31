package in.bhavanishankar.cache;

import java.util.*;

class Record implements Comparable<Record> {
    private int key,value,lastAcceesed;

    public Record(int key, int value, int lastAccessed) {
        this.key = key;
        this.value = value;
        this.lastAcceesed = lastAccessed;
    }

    public int getKey() {
        return key;
    }

    public int getLastAcceesed() {
        return lastAcceesed;
    }

    public void setLastAcceesed(int newAccesstimestamp) {
        this.lastAcceesed = newAccesstimestamp;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Record o) {
        int diff = this.lastAcceesed - o.getLastAcceesed();
        return Integer.compare(diff,0);
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class LRUCache {

    private final Queue<Record> priorityQueue;
    private final int capacity;
    private final Map<Integer,Record> keyRecordMap;
    private int currentTimestamp;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.priorityQueue = new PriorityQueue<>(capacity);
        this.keyRecordMap = new HashMap<>(capacity);
        this.currentTimestamp = 0;
    }

    public int get(int key) {
        ++this.currentTimestamp;
        Record record = this.keyRecordMap.get(key);
        if (record == null) return -1;
        this.keyRecordMap.put(key,record);
        this.priorityQueue.remove(record);
        record.setLastAcceesed(this.currentTimestamp);
        this.priorityQueue.add(record);
        return record.getValue();
    }

    public void put(int key, int value) {
        ++this.currentTimestamp;
        Record record = null;
        if (keyRecordMap.containsKey(key)) {
            record = keyRecordMap.get(key);
            record.setValue(value);
            record.setLastAcceesed(this.currentTimestamp);
            this.keyRecordMap.remove(record.getKey());
            this.priorityQueue.remove(record);
        } else {
            record = new Record(key,value,this.currentTimestamp);
            if(this.priorityQueue.size() == this.capacity) {
                Record evict_record = this.priorityQueue.poll();
                this.keyRecordMap.remove(evict_record.getKey());
                IO.println("Popped record :: "+evict_record.getKey()+" Value ::"+evict_record.getValue());
            }
        }

        this.priorityQueue.add(record);
        this.keyRecordMap.put(key, record);
    }
}
