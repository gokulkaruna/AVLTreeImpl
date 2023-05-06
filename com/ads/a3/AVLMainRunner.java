package com.ads.a3;

import java.util.Scanner;

public class AVLMainRunner
{
    public static void main(String[] args)
    {        
        int choice;
		int key;
		Scanner sc = new Scanner(System.in);
		AVLTree tree = new AVLTree();
        
		//input array with 20 elements
//		int inputArray[] = {81, 50, 24, 30, 95, 61, 11, 37, 45, 22, 87, 53, 78, 82, 5, 15, 56, 44, 64, 49};
		int inputArray[] = {5,6,8,3,2,4,7};
	
		
		System.out.println("--------------------------------");
		System.out.println("AVL Tree Implementation");
		System.out.println("--------------------------------");
		
		
		//input of 20 keys into the tree
		System.out.println("Inserting the keys... ");
		for(int i=0; i<7; i++) {
			System.out.println("inserting "+inputArray[i]);
			tree.insertKey(inputArray[i]);
		}
		System.out.println();
		
		while(true) {
			System.out.println("Enter your choice:\n1. Insert Key\n2. Delete Key\n3. Find Key\n4. Show Tree\n5. Destroy tree\n6. Exit\n");
			choice = sc.nextInt();
			
			switch(choice) {
			
				case 1:	System.out.println("\nEnter the key to be inserted: ");
				  		key = sc.nextInt();
				  		if(tree.insertKey(key) == 1)
				  			System.out.println("\nInsertion successful\n");
				  		else
				  			System.out.println("\nKey with the entered value already exists in the tree\n");
						break;
					
						
				case 2:	System.out.println("Enter the key to be deleted: ");
						key = sc.nextInt();
				  		if(tree.deleteKey(key) == 1)
				  			System.out.println("\nDeletion successful\n");
				  		else
				  			System.out.println("\nNo node with entered value found in tree\n");
						break;
						
						
				case 3:	System.out.println("Enter the key to be searched: "); 
						key = sc.nextInt();
						if(tree.searchKey(key) == 1) 
							System.out.println("\nThe key "+key+" was found successfully\n");
						else
							System.out.println("\nThe key "+key+" was found not found!\n");
						break;
						
						
				case 4: System.out.println("Displaying the AVL Tree in PreOrder Traversal");
						tree.preOrder(tree.Root);
						System.out.println("\n");
						break;
						
				case 5: System.out.println("Destroying the tree.....\n");
						tree.destroyTree(tree.Root);
						tree.Root=null;
						System.out.println("Tree destroyed!\n");
						break;
						
				case 6: System.out.println("Exitting program........\n");
						System.out.println("Exitted!\n");
						System.exit(0);
						break;
										
				default: System.out.println("Please enter the correct option :) \n");
						
			}
		}
		 
    }
}

