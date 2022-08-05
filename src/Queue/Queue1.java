
package Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Queue1 {
    private ListNode front;
    private ListNode rear;
    private int length;
    
    private class ListNode{
        private int data;
        private ListNode next;
        
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public Queue1(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void enQueue(int data){
        ListNode temp=new ListNode(data);
        if(isEmpty()){
            front=temp;
        }
        else{
            rear.next=temp;
        }
        rear=temp;
        length++;
    }
    public int deQueue(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int result=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        length--;
        return result;
    }
    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current=front;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current=current.next;
        }
        System.out.println("null");
    }
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return front.data;
    }
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return rear.data;
    }
    //create binary system from 1 to n
    public String[] generateBinaryNumbers(int n){
        String[] result=new String[n];
        Queue<String> q=new LinkedList<>();
        q.offer("1");
        for(int i=0;i<n;i++){
            result[i]=q.poll();
            String n1=result[i]+"0";
            String n2=result[i]+"1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    } 
    public static void main(String[] args){
        Queue1 queue=new Queue1();
        queue.enQueue(10);
        queue.enQueue(15);
        queue.enQueue(20);
        
        System.out.println(queue.first());
        
        queue.print();
        
        System.out.println(queue.generateBinaryNumbers(4).length);
    }
}
