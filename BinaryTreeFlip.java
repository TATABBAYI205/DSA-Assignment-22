package Assignment22;

class Node 
{
 int data;
 Node left, right;
 Node(int item) 
 {
     data = item;
     left = right = null;
 }
}

class BinaryTreeFlip 
{
 static Node flipBinaryTree(Node root) 
 {
     if (root == null || (root.left == null && root.right == null)) 
     {
         return root;
     }
     Node flippedLeft = flipBinaryTree(root.left);
     Node flippedRight = flipBinaryTree(root.right);
     root.left = null;
     root.right = null;
     flippedLeft.right = root;
     flippedLeft.left = flippedRight;
     return flippedLeft;
 }
 static void inorderTraversal(Node root) 
 {
     if (root == null)
         return;
     inorderTraversal(root.left);
     System.out.print(root.data + " ");
     inorderTraversal(root.right);
 }
 public static void main(String[] args)
 {
     Node root = new Node(1);
     root.left = new Node(2);
     root.right = new Node(3);
     root.left.left = new Node(4);
     root.left.right = new Node(5);
     Node flippedRoot = flipBinaryTree(root);
     inorderTraversal(flippedRoot);
 }
}

