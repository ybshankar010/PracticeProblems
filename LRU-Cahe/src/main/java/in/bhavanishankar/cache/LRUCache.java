package in.bhavanishankar.cache;

import java.util.*;

class Node {
    private  int key, value;
    private Node prevPointer,nextPointer;

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
    public Node getNext() {
        return nextPointer;
    }

    public Node getPrev(){
        return prevPointer;
    }

    public void setPrev(Node node) {
        this.prevPointer = node;
    }
    public void setNext(Node node) {
        this.nextPointer = node;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class LRUCache {

    private final int capacity;
    private final Map<Integer,Node> keyRecordMap;
    private Node head,tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.keyRecordMap = new HashMap<>(capacity);
        this.head = this.tail = null;
    }

    public int get(int key) {
        Node curr = this.keyRecordMap.get(key);
        if (curr == null) return -1;
        if (curr == this.head) return curr.getValue();
        Node previousNode,nextNode;
        if (curr == this.tail) {
            previousNode = this.tail.getPrev();
            this.tail.setPrev(null);
            this.tail = previousNode;
            this.tail.setNext(null);
        } else {
            previousNode = curr.getPrev();
            nextNode = curr.getNext();

            previousNode.setNext(nextNode);
            nextNode.setPrev(previousNode);
            curr.setNext(null);
            curr.setPrev(null);
        }
        addHead(curr);

        return curr.getValue();
    }

    private void addHead(Node node) {
        this.head.setPrev(node);
        node.setNext(this.head);
        this.head = node;
    }

    public void put(int key, int value) {
        Node curr = this.keyRecordMap.get(key);
        if (curr == null) {
            curr = new Node(key,value);
            if(this.head == null) {
                this.head = this.tail = curr;
            } else if(this.keyRecordMap.size() == capacity) {
                this.keyRecordMap.remove(this.tail.getKey());
                Node previousNode = this.tail.getPrev();
                if (previousNode != null) {
                    this.tail.setPrev(null);
                    this.tail = previousNode;
                    this.tail.setNext(null);
                }
                addHead(curr);
            } else {
                addHead(curr);
            }
        } else {
            curr.setValue(value);
            if (this.tail == curr && this.tail != this.head) {
                this.tail = this.tail.getPrev();
                this.tail.setNext(null);
                addHead(curr);
            } else if(this.head == curr) {
                // do nothing
            } else {
                Node previousNode = curr.getPrev();
                Node nextNode = curr.getNext();

                previousNode.setNext(nextNode);
                nextNode.setPrev(previousNode);
                curr.setNext(null);
                curr.setPrev(null);
                addHead(curr);
            }
        }

        this.keyRecordMap.put(key,curr);
    }
}
