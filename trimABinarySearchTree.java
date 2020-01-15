/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
Bonus points if you could solve it both recursively and iteratively.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//          Iterative Version
//First we iterative through the tree from left until null then right. During the traversal we add the current node's value into a queue. 
//Then we have a method to built a tree from scratch by using a Queue to get the order which we traverse through the original tree.
class trimABinarySearchTree{
    public TreeNode trimBST(TreeNode root, int L, int R) {
        
        Stack<TreeNode> stack = new Stack <>();
        Queue<Integer> q = new LinkedList<>();
        
        while( root != null || !stack.isEmpty() )
        {
            while( root != null)
            {
                if( root.val >= L && root.val <= R)
                    q.add(root.val);
                    
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
           return builtTree(q);
    }
    
    public TreeNode builtTree(Queue<Integer> q)
    {
        TreeNode root = null;
        TreeNode pointer = null;
        
        if( root == null )
        {
            root = new TreeNode ( q.remove());
            pointer = root;
        }   
        while( !q.isEmpty() )
        {    
                 int target = q.remove();
                 boolean inserted = false; 
            
            while( inserted == false)     
                {
                    if(target < pointer.val)
                    {
                        if(pointer.left == null)
                        {
                            pointer.left = new TreeNode(target);
                            pointer = pointer.left;
                            inserted = true;
                        }
                        else
                            pointer = pointer.left;
                    }
                    else if ( pointer.right == null)
                    {
                        pointer.right = new TreeNode(target);
                        pointer = pointer.right;
                        inserted = true;
                    }
                    else
                        pointer = pointer.right;
                 }
                    pointer = root;
        }
        return root;
    }
}
