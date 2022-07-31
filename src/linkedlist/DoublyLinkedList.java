
package linkedlist;

import java.util.*;


public class DoublyLinkedList {
    
    private ListNode head;
    private ListNode tail;
    private int length;
    
    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;
        
        public ListNode(int data){
            this.data=data;
        }
    }
    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.length=0;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int length(){
        return length;
    }
    
    public void displayForward(){
        if(head==null){
            return;
        }
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void displayBackward(){
        if(tail==null){
            return;
        }
        ListNode temp=tail;
        while(temp!=null){
            System.out.print(temp.data+" --> ");
            temp=temp.previous;
        }
        System.out.println("null");
    }
    public void insertLast(int value){
        ListNode newNode =new ListNode(value);
        if(isEmpty()){
            head=newNode;
        }else{
            tail.next=newNode;
        }
        newNode.previous=tail;
        tail=newNode;
        length++;
    }
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        if(isEmpty()){
            tail=newNode;
        }else{
            head.previous=newNode;
        }
        newNode.next=head;
        head=newNode;
        length++;
        
    }
    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp=head;
        if(head==tail){
            tail=null;
        }else{
            head.next.previous=null;
            head=head.next;
        }
        
        temp.next=null;
        length--;
        return temp;
    }
    
    public static void main(String[] args){
        DoublyLinkedList dll=new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertFirst(15);
        dll.insertFirst(25);
        
        
        dll.displayForward();
        dll.deleteFirst();
        dll.displayBackward();
    }
}
