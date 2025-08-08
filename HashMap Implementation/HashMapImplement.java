import java.util.*;

public class HashMapImplement {

    public static class MyHashMap<K, V>{
        private final int INITIAL_CAPACITY = 4;
        private final double LOAD_FACTOR = 0.75;
        private int n = 0;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Node>[] buckets;

        private void initBuckets(int N){
            buckets = new LinkedList[N];
            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public MyHashMap() {
            initBuckets(INITIAL_CAPACITY);
        }

        private int hashfunc(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        private int searchInBucket(LinkedList<Node> ll, K key){
            for(int i = 0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            initBuckets(oldBuckets.length * 2);
            n = 0;

            for(LinkedList<Node> bucket : oldBuckets) {
                for(Node node : bucket) {
                    put(node.key, node.value);
                }
            }
        }

        public int size(){
            return n;
        }

        public void put(K key, V value){
            int bi = hashfunc(key);
            LinkedList<Node> curBucket = buckets[bi];
            int si = searchInBucket(curBucket, key);

            if(si == -1){
                Node newNode = new Node(key, value);
                curBucket.add(newNode);
                n++;
            } else{
                Node existingNode = curBucket.get(si);
                existingNode.value = value;
            }

            if(LOAD_FACTOR * buckets.length <= n) {
                rehash();
            }

        }

        public V get(K key){
            int bi = hashfunc(key);
            LinkedList<Node> curBucket = buckets[bi];
            int si = searchInBucket(curBucket, key);

            if(si == -1){
                return null;
            } else {
                return curBucket.get(si).value;
            }
        }

        public V remove(K key){
            int bi = hashfunc(key);
            LinkedList<Node> curBucket = buckets[bi];
            int si = searchInBucket(curBucket, key);
            if(si == -1){
                return null;            
            } else{
                Node removeNode = curBucket.get(si);
                V value = removeNode.value;
                curBucket.remove(si);
                n--;
                return value;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        System.out.println("capacity: " + map.buckets.length);
        map.put(1, 100);
        System.out.println("capacity: " + map.buckets.length);
        map.put(2, 200);
        System.out.println("capacity: " + map.buckets.length);
        map.put(3, 300);
        System.out.println("Size: " + map.size());
        System.out.println("Get key 2: " + map.get(2));
        System.out.println("Remove key 1: " + map.remove(1)); 
        System.out.println("capacity: " + map.buckets.length);  
        System.out.println("Size is : " + map.size());

        map.put(4, 400);
        System.out.println("Get key 4: " + map.get(4));
        map.put(2, 250);
        System.out.println("Updated value for key 2: " + map.get(2));
        System.out.println("Size after updates: " + map.size());
        System.out.println("capacity after updates: " + map.buckets.length);
    }
}
