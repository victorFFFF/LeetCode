/*A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false
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
class univaluedBinaryTree {
    
    HashMap<Integer, Integer> hMap = new HashMap<>();
        
    public boolean isUnivalTree(TreeNode root) {
        
        if(root != null)
        {
           hMap.put(root.val, root.val);
           isUnivalTree(root.left);
           isUnivalTree(root.right);
            
           if(hMap.size() == 1)
               return true;
        }
        return false;
    }
}
