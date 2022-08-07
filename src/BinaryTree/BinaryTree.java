
package BinaryTree;

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
    public void createBinaryTree(){
        TreeNode first=new TreeNode(9);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(1);
        
        
        root=first;
        first.left=second;
        first.right=third;
        
        second.left=fourth;
        second.right=fifth;
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
    public static void main(String[] args){
        BinaryTree bt=new BinaryTree();
        bt.createBinaryTree();
        bt.IinOrder(bt.root);
    }
}
