package Assignment22;


class Node3 
{
 int data;
 Node3 left, right;
 Node3(int item) 
 {
     data = item;
     left = right = null;
 }
}
class TraversalConsistencyCheck 
{
 static boolean isSameTree(int[] inorder, int[] preorder, int[] postorder) 
 {
     if (inorder.length != preorder.length || inorder.length != postorder.length) 
     {
         return false;
     }
     Node3 root = constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
     int[] constructedPostorder = new int[postorder.length];
     postorderTraversal(root, constructedPostorder, 0);
     for (int i = 0; i < postorder.length; i++) 
     {
         if (postorder[i] != constructedPostorder[i]) 
         {
             return false;
         }
     }
     return true;
 }
 static Node3 constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) 
 {
     if (preStart > preEnd || inStart > inEnd) 
     {
         return null;
     }

     int rootData = preorder[preStart];
     Node3 root = new Node3(rootData);
     int rootIndexInorder = -1;
     for (int i = inStart; i <= inEnd; i++) 
     {
         if (inorder[i] == rootData) 
         {
             rootIndexInorder = i;
             break;
         }
     }
     int leftSubtreeSize = rootIndexInorder - inStart;
     int rightSubtreeSize = inEnd - rootIndexInorder;
     root.left = constructTree(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart,rootIndexInorder - 1);
     root.right = constructTree(preorder, preEnd - rightSubtreeSize + 1, preEnd, inorder, rootIndexInorder + 1,inEnd);
     return root;
 }
 static int postorderTraversal(Node3 root, int[] postorder, int index) 
 {
     if (root == null) 
     {
         return index;
     }
     index = postorderTraversal(root.left, postorder, index);
     index = postorderTraversal(root.right, postorder, index);
     postorder[index] = root.data;
     return index + 1;
 }
 public static void main(String[] args) 
 {
     int[] inorder = { 4, 2, 5, 1, 3 };
     int[] preorder = { 1, 2, 4, 5, 3 };
     int[] postorder = { 4, 5, 2, 3, 1 };
     boolean isSame = isSameTree(inorder, preorder, postorder);
     System.out.println(isSame ? "Yes" : "No");
 }
}

