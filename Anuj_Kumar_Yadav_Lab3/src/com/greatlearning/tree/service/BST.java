package com.greatlearning.tree.service;

import java.util.ArrayList;
import java.util.List;

public class BST { 
    //node class that defines BST node
    public class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
        
        public int getKey() {
        	return this.key;
        }
    } 
    // BST root node 
    Node root; 
    List<BST.Node> lst = new ArrayList<BST.Node>();
  
   // Constructor for BST =>initial empty tree
    public BST(){ 
        root = null; 
    } 
    //delete a node from BST
    public void deleteKey(int key) { 
        root = delete_Recursive(root, key); 
    } 
   
    //recursive delete function
    public Node delete_Recursive(Node root, int key)  { 
        //tree is empty
        if (root == null)  return root; 
   
        //traverse the tree
        if (key < root.key)     //traverse left subtree 
            root.left = delete_Recursive(root.left, key); 
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key); 
        else  { 
            // node contains only one child
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
   
            // node has two children; 
            //get inorder successor (min value in the right subtree) 
            root.key = minValue(root.right); 
   
            // Delete the inorder successor 
            root.right = delete_Recursive(root.right, root.key); 
        } 
        return root; 
    } 
   
    int minValue(Node root)  { 
        //initially minval = root
        int minval = root.key; 
        //find minval
        while (root.left != null)  { 
            minval = root.left.key; 
            root = root.left; 
        } 
        return minval; 
    } 
   
    // insert a node in BST 
    public void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
   
    //recursive insert function
    public  Node insert_Recursive(Node root, int key) { 
          //tree is empty
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key); 
          // return pointer
        return root; 
    } 
 
// method for inorder traversal of BST 
    public List<Node> inorder() { 
        return inorder_Recursive(root); 
    } 
   
    // recursively traverse the BST  
    public List<BST.Node> inorder_Recursive(Node root) { 
    	
        if (root != null) { 
            inorder_Recursive(root.left); 
            lst.add(root);
            //System.out.print(root.key + " "); 
            inorder_Recursive(root.right); 
        } 
        return lst;
    } 
     
    public boolean search(int key)  { 
        root = search_Recursive(root, key); 
        if (root!= null)
            return true;
        else
            return false;
    } 
   
    //recursive insert function
    public Node search_Recursive(Node root, int key)  { 
        // Base Cases: root is null or key is present at root 
        if (root==null || root.key==key) 
            return root; 
        // val is greater than root's key 
        if (root.key > key) 
            return search_Recursive(root.left, key); 
        // val is less than root's key 
        return search_Recursive(root.right, key); 
    } 
}