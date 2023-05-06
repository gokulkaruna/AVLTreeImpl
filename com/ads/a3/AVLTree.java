package com.ads.a3;



class AVLTree
{	
	
	 Node Root;
	
	//---------------------------------------------------------------
	 //insert key methods
	//---------------------------------------------------------------
		//Checks if the key is already present and calls insertNode if not present already
		//Same as BST insertion
	 
		   int insertKey(int key)
		   {
		       if (findNode(Root , key) == null)
		       {
		           Root = insertNode(Root, key);
		           return 1;
		       }
		       return 0; 
		   }
		   
		   
		   Node insertNode(Node root, int key)
		   {
		       if (root == null)
		           return new Node(key);
	
		       else if (key < root.value)
		           root.left = insertNode(root.left, key);
	
		       else
		           root.right = insertNode(root.right, key);
		       
		       
		     //Balance Tree to be performed after each insertion to ensure
		     //AVL tree properties are maintained
	
		       return balanceTree(root); 
		   }
	   
	
	//---------------------------------------------------------------
	   //Delete key methods
	//---------------------------------------------------------------
	   //Checks if the key is  present and calls removeNode if not returns 0;
	   //same as BST deletion
	   //Handles 3 cases
	   			// delete node with only left node
	   			// delete node with only right node
	   			// delete node with both left and right nodes [ InOrder Successor Replacement]
	   //Balance as usual after removal
		   
		   int deleteKey(int key)
		   {
		       if (findNode(Root , key) != null)
		       {
		           Root = removeNode(Root , key);
		           return 1;
		       }
		       return 0;
		   }
		   
		   Node removeNode(Node root, int key)
		   {
		       if (root == null)	
		           return root;
	
		       else if (key < root.value)
		           root.left = removeNode(root.left, key);
	
		       else if (key > root.value)
		           root.right = removeNode(root.right, key);
	
		       else
		       {
		           if (root.right == null)
		               root = root.left;
	
		           else if (root.left == null)
		               root = root.right;
	
		           else
		           {
		               Node temp = successor(root.right);
		               root.value = temp.value;
		               root.right = removeNode(root.right, root.value);
		           }
		       }
	
		       if (root == null)
		           return root;
	
		       else
		           // Balances the tree after deletion
		           return balanceTree(root);
		   }
		   
		   
		   // Successor returns the next largest node
		   //which will be in the left most of the right subtree
		   Node successor(Node root)
		   {
		       if (root.left != null)
		           return successor(root.left);
		
		       else
		           return root;
		   }
		
	   
	 //--------------------------------------------------------------- 
	  //search key
    // --------------------------------------------------------------
		   
		//Checks if the key is  present using findNode and returns 1 if found
		   
		   int searchKey(int key)
		   {
		       if(findNode(Root, key) == null)
		           return 0;
		       else
		           return 1;
		   }
		  
		   
		   Node findNode(Node root, int key)
		   {
		       if (root == null || key==root.value)
		           return root;
	
		       if (key < root.value)
		           return findNode(root.left, key);
	
		       else
		           return findNode(root.right, key);
		   }
		   
	   
   //---------------------------------------------------------------
	   //balancing part
   //--------------------------------------------------------------

	
	   //returns the height of the node
	   int getHeight(Node key)
	   {
	       if (key == null)
	          return -1 ;
	
	       else
	           return key.height;
	   }
	
	
	   // Balance computes the balance factor of the node
	   int getBalanceFactor(Node key)
	   {
	       if (key == null)
	          return -1;
	
	       else
	           return (getHeight(key.right) - getHeight(key.left) );
	   }
	
	   
	   // updateHeight updates the height of the node
	   void updateHeight(Node key)
	   {
	       int l = getHeight(key.left);
	       int r = getHeight(key.right);
	
	       key.height = Math.max(l , r) + 1;
	   }
	   
	   //Left rotation given a pointer to the node to be rotated
	   Node rotateLeft(Node x)
	   {
	       Node y = x.right;
	       Node T2 = y.left;
	
	       y.left = x;
	       x.right = T2;
	
	       updateHeight(x);
	       updateHeight(y);
	
	       return y;
	   }
	
	 //right rotation given a pointer to the node to be rotated
	   Node rotateRight(Node y)
	   {
	       Node x = y.left;
	       Node T2 = x.right;
	
	       x.right = y;
	       y.left = T2;
	
	       updateHeight(y);
	       updateHeight(x);
	
	       return x;
	   }
	
	   
	   // balanceTree balances the tree using rotations after an insertion or deletion
	   Node balanceTree(Node root)
	   {
	       updateHeight(root);
	
	       int balance = getBalanceFactor(root);
	
	       if (balance > 1) //R
	       {
	           if (getBalanceFactor(root.right) < 0)//RL
	           {
	               root.right = rotateRight(root.right);
	               return rotateLeft(root);
	           }
	
	           else //RR
	               return rotateLeft(root);
	       }
	
	       if (balance < -1)//L
	       {
	           if (getBalanceFactor(root.left) > 0)//LR
	           {
	               root.left = rotateLeft(root.left);
	               return rotateRight(root);
	           }
	           else//LL
	               return rotateRight(root);
	       }
	
	       return root;
	   }
	




   //------------------------------------------------------
	   //Destroy Tree
  //--------------------------------------------------------
	   //Post Order Deletion is happening here as Root has to 
	   //get deleted once their left and right children deletion is done
	   void destroyTree(Node root) {
		   
		   if(root == null) {
		        return;
		    }
		   destroyTree(root.left);
		   destroyTree(root.right);
		   
		   System.out.println("deleted node "+root.value);
		   root = null;
	   }
	   
	   
	   
   //-----------------------------------------------------------
	   //Display Tree
   //------------------------------------------------------------

   //Normal PreOrder Traversal

	   void preOrder(Node root)
	    {
	        if(root == null)
	        {
	            System.out.println("No nodes in the tree");
	            return;
	        }

	        System.out.print(root.value + " ");
	        if(root.left != null)
	            preOrder(root.left);
	        if(root.right != null)
	            preOrder(root.right);
	     
	    }
	   
	

}



