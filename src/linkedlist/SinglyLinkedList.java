
package linkedlist;

public class SinglyLinkedList {
    private ListNode head;
    private static class ListNode{
        private int data;
        private ListNode next;
        
        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void display(){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.data+" --> ");
            current=current.next;
        }
        System.out.println("Null");
    }
    public int length(){
        if(head==null){
            return 0;
        }
        int count=0;
        ListNode current=head;
        while(current!=null){
            count++;
            current=current.next;
        }
        return count;
    }
    public void insertFirst(int value){
        ListNode newNode =new ListNode(value);
        newNode.next=head;
        head=newNode;
        
    }
    public void insert(int position,int value){
        ListNode node=new ListNode(value);
        if(position==1){
            node.next=head;
            head=node;
        }
        else{
            int count=1;
            ListNode previous=head;
            while(count<position-1){
                
                previous=previous.next;
                count++;
            }
            
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if(head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    public ListNode deleteFirst(){
        if(head==null){
            return null;
        }
        ListNode  temp=head;
        head=head.next;
        temp.next=null;
        return temp;
        
    }
    public void delete(int position){
        if(position==1){
            head=head.next;
        }
        else{
            ListNode previous = head;
            int count=1;
            while(count < position-1){
                previous=previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next=current.next;
        }
    }
    public ListNode deleteLast(){
        if(head==null||head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode previous=null;
        while(current.next !=null){
            previous = current;
            current=current.next;
        }
        previous.next=null;
        return current;
    }
    public boolean find(int searchKey){
        if(head==null)
            return false;
        ListNode current=head;
        while(current!=null){
            if(current.data==searchKey){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public void reverse(){
        if(head == null){
            return;
        }
        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;
        
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head=previous;
        
    }
    public ListNode getMiddleNode(){
        if(head==null){
            return null;
        }
        ListNode slowptr=head;
        ListNode fastptr=head;        
        while(fastptr!=null && fastptr.next!=null){
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }
        return slowptr; 
    }
    public ListNode getNthNodeFromEnd(int n){
        if(head==null)
            return null;
        if(n<=0)
            throw new IllegalArgumentException("Invalid  Value : n = "+n);
        ListNode mainPtr=head;
        ListNode refPtr=head;
        
        int count=0;
        while(count<n){
            if(refPtr==null){
                throw new IllegalArgumentException(n+"is greater than the number of nodes in list");
            }
            refPtr=refPtr.next;
            count++;
            
        }
        while(refPtr!=null){
            refPtr=refPtr.next;
            mainPtr=mainPtr.next;
        }
        return mainPtr;
        
    }
    //In Sorted list
    public void removeDuplicates(){
        if(head==null){
            return;
        }
        ListNode current=head;
        
        while(current !=null && current.next!=null){
            if(current.data == current.next.data){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
    }
    public ListNode insertSortedList(int value){
        ListNode newNode =new ListNode(value);
        
        if(head==null){
            return newNode;
        }
        
        ListNode current=head;
        ListNode temp=null;
        if(current.data>newNode.data){
            newNode.next=current;
            head=newNode;
            return head;
        }
        while(current!=null&&current.data<newNode.data){
            temp=current;
            current=current.next;
        }
        newNode.next=current;
        temp.next=newNode;
        return head;
    }
    public void deleteGivenKey(int key){
        ListNode current=head;
        ListNode temp=null;
        if(current!=null&&current.data==key){
            head=current.next;
            return ;
        }
        while(current!=null&&current.data!=key){
            temp=current;
            current=current.next;
        }
        if(current==null){
            return;
        }
        
        temp.next=current.next;
    }
    public boolean containsLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        
        while(fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }
    public ListNode startNodeInLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        
        while(fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            
            if(slowPtr==fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private ListNode getStartingNode(ListNode slowPtr){
        ListNode temp=head;
        while(temp!=slowPtr){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        return temp;
    }
    public void removeLoop(){
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        
        while(fastPtr!=null&&fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            
            if(slowPtr==fastPtr){
                removeLoop(slowPtr);
                return;
            }
        }
        
    }
    private void removeLoop(ListNode slowPtr){
        ListNode temp=head;
        while(temp.next!=slowPtr.next){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        slowPtr.next=null;
    }
    public void createALoopLinkedList(){
        ListNode first=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode sixth=new ListNode(6);
        
        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }
    public static ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(a!=null&&b!=null){
            if(a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else{
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        
        if(a==null){
            tail.next=b;
        }else{
            tail.next=a;
        }
        
        return dummy.next;
        
    }
    //this is leetcode problem a and b is reverse
    public static ListNode add(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        
        int carry=0;
        while(a!=null||b!=null){
            int x=(a!=null)?a.data:0;
            int y=(b!=null)?b.data:0;
            
            int sum=carry+x+y;
            carry=sum/10;
            tail.next=new ListNode(sum%10);
            
            tail=tail.next;
            if(a!=null)a=a.next;
            if(b!=null)b=b.next;
        }
        if(carry>0){
            tail.next=new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        //SinglyLinkedList sll=new SinglyLinkedList();
/*      sll.head=new ListNode(10);
        ListNode second=new ListNode(1);
        ListNode third =new ListNode(8);
        ListNode fourth=new ListNode(11);
        
        sll.head.next=second;
        second.next=third;
        third.next=fourth;
        
        sll.insertFirst(17);
        
        sll.insertLast(20);
        
        sll.insert(2,7);
        
        System.out.println(sll.getMiddleNode().data);
        
        sll.display();
*/
        
        
        //System.out.println(sll.deleteFirst().data);
        
        //System.out.println(sll.deleteLast().data);
        
        //sll.delete(2);
        
        //sll.reverse();
        //sll.display();
        //System.out.println("Length = "+sll.length());
        
/*      if(sll.find(17))
            System.out.println("Search Key Found");
        else
            System.out.println("Search Key No Found");
*/
        
/*        //System.out.println(sll.getNthNodeFromEnd(2).data);
        
        /*sll.insertFirst(15);
        sll.insertFirst(13);
        sll.insertFirst(12);
        sll.insertFirst(11);
        sll.insertFirst(10);
        
        
        sll.insertSortedList(9);
        //sll.removeDuplicates();
        
        sll.deleteGivenKey(9);
        
        sll.display();
*/
        
/*      sll.createALoopLinkedList();
        System.out.println(sll.containsLoop());
        System.out.println(sll.startNodeInLoop().data);
        
        sll.removeLoop();
        sll.display();
*/
       
/*      SinglyLinkedList sll1=new SinglyLinkedList();
       sll1.insertLast(1);
       sll1.insertLast(4);
       sll1.insertLast(8);
       
       
       SinglyLinkedList sll2=new SinglyLinkedList();
       sll2.insertLast(3);
       sll2.insertLast(5);
       sll2.insertLast(8);
       sll2.insertLast(9);
       sll2.insertLast(14);
       sll2.insertLast(18);
       
       sll1.display();
       sll2.display();
       
       
        SinglyLinkedList result=new SinglyLinkedList();
        result.head=merge(sll1.head,sll2.head);
        
        result.display();
*/
       
        
       SinglyLinkedList sll1=new SinglyLinkedList();
       sll1.insertLast(7);
       sll1.insertLast(4);
       sll1.insertLast(9);
       
       SinglyLinkedList sll2=new SinglyLinkedList();
       sll2.insertLast(5);
       sll2.insertLast(6);
       
       SinglyLinkedList result1=new SinglyLinkedList();
       result1.head=add(sll1.head,sll2.head);
       
       result1.display();
                
            
        
          
    }
    
}
