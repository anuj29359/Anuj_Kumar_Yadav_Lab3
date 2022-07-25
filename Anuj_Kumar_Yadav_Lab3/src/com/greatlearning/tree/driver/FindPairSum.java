package com.greatlearning.tree.driver;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;
import java.util.Scanner;

import com.greatlearning.tree.service.BST;
import com.greatlearning.tree.service.BST.Node;

public class FindPairSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number - ");
		int num = sc.nextInt();
		BST bst = new BST(); 
        /* BST tree example
              40 
           /     \ 
          20      60 
         /  \    /   \
        10   30  50   70

        */
        //insert data into BST
        bst.insert(40); 
        bst.insert(20); 
        bst.insert(60); 
        bst.insert(10); 
        bst.insert(30); 
        bst.insert(50); 
        bst.insert(70);
        
        //System.out.println("The BST Created with input data(Left-root-right):"); 
        List<Node> arr = bst.inorder(); 
        boolean flg = false;
        for(Node n : arr) {
        	if(n.getKey() < num && flg == false) {
        		int rem = num-n.getKey();
        		for (int i = 0; i < arr.size(); i++) {
					if(rem == arr.get(i).getKey() && !arr.get(i).equals(n)) {
						System.out.println();
						System.out.println("Pair is ("+ n.getKey() + "," + arr.get(i).getKey() + ") for the entered number " + num);
						flg = true;
						return;
					}
				}
        	}
        	
        	
        }
        if(flg == false){
        	System.out.println();
    		System.out.println("Pair nodes are not found for the entered number " + num);
        }

	}

}
