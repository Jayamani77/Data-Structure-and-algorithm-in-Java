
package Hashing;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;//capacity
    private int size;// no of pairs
    
    public HashTable(){
        this(10);
    }
    public HashTable(int capacity){
        this.numOfBuckets=capacity;
        buckets=new HashNode[numOfBuckets];
        this.size=0;
    }
    private class HashNode{
        private Integer key;//can be generic
        private String value;//can be generic 
        private HashNode next;
        
        public HashNode(Integer key,String value){
            this.key=key;
            this.value=value;
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int getBucketIndex(Integer key){
        return key%numOfBuckets;
    }
    public void put(Integer key,String value){
        if(key==null||value==null){
            throw new IllegalArgumentException("key or value is null");
        }
        int bucketIndex=getBucketIndex(key);
        HashNode head=buckets[bucketIndex];
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return ;
            }
            head=head.next;
        }
        size++;
        head=buckets[bucketIndex];
        HashNode node =new HashNode(key,value);
        node.next=head;
        buckets[bucketIndex]=node;
    }
    public String get(Integer key){
        if(key==null){
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex=getBucketIndex(key);
        HashNode head=buckets[bucketIndex];
        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;
    }
    public String remove(Integer key){
        if(key==null){
            throw new IllegalArgumentException("Key is null");
        }
        int bucketIndex=getBucketIndex(key);
        HashNode head=buckets[bucketIndex];
        HashNode previous=null;
        while(head!=null){
            if(head.key.equals(key)){
                break;
            }
            previous=head;
            head=head.next;
        }
        if(head==null){
            return null;
        }
        size--;
        if(previous!=null){
            previous.next=head.next;
        }
        else{
            buckets[bucketIndex]=head.next;
        }
        return head.value;
    }
    public static void main(String[] args){
        HashTable ht=new HashTable();
        ht.put(105,"Tom");
        ht.put(21,"john");
        ht.put(21,"mari");
        System.out.println(ht.size);
        System.out.println(ht.get(21));
        System.out.println(ht.remove(21));
        System.out.println(ht.size);
    }
}
