
package BinaryTree;

import BinarySearchTree.BinarySearchTree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;
        
        public TreeNode(int data){
            this.data=data;
        }
    }
    //recursive
    public void RpreOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        RpreOrder(root.left);
        RpreOrder(root.right);
    }
    //iterative
    public void IpreOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    //inorder recursive
    public void RinOrder(TreeNode root){
        if(root==null){
            return;
        }
        RinOrder(root.left);
        System.out.print(root.data+" ");
        RinOrder(root.right);
    }
    //Iterative inorder
    public void IinOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        
        while(!stack.isEmpty()||temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }
            else{
                temp=stack.pop();
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }
    //Recursive postorder
    public void RpostOrder(TreeNode root){
        if(root==null){
            return;
        }
        RpostOrder(root.left);
        RpostOrder(root.right);
        System.out.print(root.data+" ");
    }
    //Iterative postOrder
    public void IpostOrder(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode current=root;
        Stack<TreeNode> stack=new Stack<>();
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
    public void levelOrder(){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        
    }
    public int findMax(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int result=root.data;
        int left=findMax(root.left);
        int right=findMax(root.right);
        
        if(left>result){
            result=left;
        }
        if(right>result){
            result=right;
        }
        return result;
    }
    //leetcode problem
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            TreeNode n1=stack.pop();
            TreeNode n2=stack.pop();
            if(n1==null&&n2==null)continue;
            if(n1==null||n2==null||n1.data!=n2.data){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }
    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(8);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);
        TreeNode sixth=new TreeNode(6);
        TreeNode seventh=new TreeNode(7);
        
        root=first;
        first.left=second;
        first.right=third;
        
        second.left=fourth;
        second.right=fifth;
        third.left=sixth;
        third.right=seventh;
    }
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        bt.createBinaryTree();
        System.out.println(bt.findMax(bt.root));
    }
}
