/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/



//ITERATIVE VERSION
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null)
            return false;
            
        
        Stack<TreeNode> stack = new Stack <>();
        Stack<Integer> sumStack = new Stack <>();
        int total  = 0;
        
        while(root != null || stack.size() != 0)
        { 
            while(root != null)
            {
                sumStack.push(total += root.val);
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if( sum == total && isLeaf(root))
                return true;
            
            root = root.right;
            
            total = sumStack.pop();
        }
        return false;
    }
    
    public boolean isLeaf(TreeNode root)
    {
        if(root.left == null && root.right == null)
            return true;
        else
            return false;
    }
}



//RECURSIVE VERSION

