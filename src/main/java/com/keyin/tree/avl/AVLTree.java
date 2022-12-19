package com.keyin.tree.avl;

import java.util.ArrayList;
import java.util.List;

public class AVLTree implements AVLTreeInterface {

    private List<Integer> tree = new ArrayList<>();


    public List<Integer> getTree() {
        return tree;
    }

    // AVL Node Class
    private class AVLNode{
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;



        public AVLNode(int value) {
            this.value = value;

        }

        @Override
        public String toString(){
            return "\nHead=" + this.value + "\n Left Node: " + leftChild + " \nRight Node: " + rightChild;
        }
    }

    private AVLNode root;


    public String clearTree(){
        root = null;
        tree.clear();
        return("The Tree has been cleared");
    }

    public String checkForEmptyTree(){
        boolean check;
        if(root == null)
            check = true;
        else
            check = false;

        return (check ? "Tree is Empty" : "Tree is not empty");

    }

    // setting up insert method using recursion

    public void insert(int value){
      root = insert(root, value);

    }

    private AVLNode insert(AVLNode root, int value){


        if(root == null)
            return new AVLNode(value);
        // checks which side to apply the inserted number to the tree then returns a value to set the root
        if(value < root.value)
           root.leftChild= insert(root.leftChild, value);

        else
           root.rightChild= insert(root.rightChild, value);

        // height is used to check if the tree is balanced
        setHeight(root);
        return balance(root);
    }

    // Helpers methods

    private AVLNode rotateLeft(AVLNode root){
       AVLNode newRoot = root.rightChild;
       root.rightChild = newRoot.leftChild;
       newRoot.leftChild = root;
       setHeight(root);
       setHeight(newRoot);
       return  newRoot;
    };

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;

    };

    private void setHeight(AVLNode  node){
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }


    private AVLNode balance(AVLNode root){
        if(isLeftHeavy(root)){
            if(balanceFactory(root.leftChild) < 0){
              root.leftChild = rotateLeft(root.leftChild);
               return  rotateRight(root);
            }

        }
        else if (isRightHeavy(root)){
            if(balanceFactory(root.rightChild) > 0){
               root.rightChild = rotateRight(root.rightChild);
               return rotateLeft(root);
            }
        }

        return root;

    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactory(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactory(node) <- 1;
    }

    private int balanceFactory(AVLNode node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node){
        if(node == null)
            return -1;
        return node.height;
    }


    //display Methods
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(AVLNode head){
        if(head!= null){
            inOrderTraversal(head.leftChild);
            System.out.println(head.value+"");
            tree.add(head.value);
            inOrderTraversal(head.rightChild);
        }

    }
    // preOrder What Tree looks like
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(AVLNode head){
        if(head !=null){
            System.out.println(head.value+"");
            tree.add(head.value);
            preOrderTraversal(head.leftChild);
            preOrderTraversal(head.rightChild);
        }
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(AVLNode head){
        if(head != null){
            postOrderTraversal(head.leftChild);
            postOrderTraversal(head.rightChild);
            System.out.println(head.value + "");
            tree.add(head.value);

        }

    }
}
