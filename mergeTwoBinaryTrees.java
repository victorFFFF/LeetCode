/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class mergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    
        TreeNode root1 = t1;
        TreeNode root2 = t2;
        TreeNode pointer = null;
        TreeNode head = null;
        TreeNode previous = null;
        Stack<TreeNode> stack1 = new Stack <>();
        Stack<TreeNode> stack2 = new Stack <>();
        Stack<TreeNode> stack3 = new Stack<>();
        int sum = 0;
        
        while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty())
        {    
            while( root1 != null || root2 != null)
            {   
                    sum = calculate(root1, root2,0);

                
                //Create new Node on the new Tree
                    if( head == null)
                    {
                        head = new TreeNode(sum);
                        pointer = head;
                    }
                    else
                    {
                        if(pointer == null)
                        {
                            previous.right = new TreeNode(sum);
                            pointer = previous.right;
                        }
                         else{   
                            pointer.left = new TreeNode(sum);
                            pointer = pointer.left;
                        }
                    }           
                    //Traverse the 2 trees
                        stack1.push(root1);
                      if(root1 != null)
                        root1 = root1.left;
                
                        stack2.push(root2);
                      if(root2 != null)
                        root2 = root2.left;
                stack3.push(pointer);
            }
                pointer = stack3.pop();
                previous = pointer;
                pointer = pointer.right;
            
                root1 = stack1.pop();
               if(root1 != null)
                    root1 = root1.right;
        
                root2 = stack2.pop();
              if(root2 != null)
                    root2 = root2.right;
        }
        return head;
    }
    public int calculate(TreeNode root1, TreeNode root2, int sum)
    {
         if( root1 != null && root2 != null)  
                         return sum = root1.val + root2.val;
                      else if ( root1 == null && root2 != null)
                         return sum = root2.val;
                      else 
                         return  sum = root1.val;
    }
}


