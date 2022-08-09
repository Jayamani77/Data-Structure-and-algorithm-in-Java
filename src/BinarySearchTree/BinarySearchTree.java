
package BinarySearchTree;

import java.util.Stack;

public class BinarySearchTree {
    private TreeNode root;
    
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data){
            this.data=data;
        }
    }
    public void insert(int value){
        root=insert(root,value);
    }
    public TreeNode insert(TreeNode root,int value){
        if(root==null){
            root=new TreeNode(value);
            return root;
        }
        if(value<root.data){
            root.left=insert(root.left,value);
        }
        else{
            root.right=insert(root.right,value);
        }
        return root;
    }
    
    public TreeNode search(int key){
        return search(root,key);
    }
    public TreeNode search(TreeNode root,int key){
        if(root==null||root.data==key){
            return root;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null){
            if(current!=null){
                stack.push(current);
                current=current.left;
            }
            else{
                TreeNode temp=stack.peek().right;
                if(temp==null){
                    temp=stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty()&&temp==stack.peek().right){
                        temp=stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    current=temp;
                }
            }
        }
    }
    //Leetcode problem we want to maintain {min,max}
    public boolean isValid(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        //min<data<max
        if(root.data<=min||root.data>=max){
            return false;
        }
        boolean left=isValid(root.left,min,root.data);
        if(left){
            boolean right=isValid(root.right,root.data,max);
            return right;
        }
        return false;
    }
  public static void main(String[] args){
      BinarySearchTree bst=new BinarySearchTree();
      bst.insert(5);
      bst.insert(3);
      bst.insert(7);
      bst.insert(1);
      
      bst.postOrder();
      
      System.out.println();
      
      if(null!=bst.search(3)){
          System.out.println("Key Found !!! ");
      }
      else{
          System.out.println("Key no Found !!");
      }
      
      System.out.println(bst.isValid(bst.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
      
      
  }  
}
