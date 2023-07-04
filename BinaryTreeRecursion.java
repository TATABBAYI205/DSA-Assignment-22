package Assignment22;

import java.util.*;
class Node2 
{
 int data;
 Node2 left, right;
 Node2(int item) 
 {
     data = item;
     left = right = null;
 }
}
class BinaryTreeRecursion 
{
 static void printRootToLeafPaths(Node2 root) 
 {
     if (root == null)
         return;
     Stack<Node2> stack = new Stack<>();
     stack.push(root);
     Map<Node2, Node2> parentMap = new HashMap<>();
     parentMap.put(root, null);
     while (!stack.isEmpty()) 
     {
         Node2 current = stack.pop();
         if (current.left == null && current.right == null) 
         {
             printPath(current, parentMap);
         }
         if (current.right != null) 
         {
             parentMap.put(current.right, current);
             stack.push(current.right);
         }
         if (current.left != null) 
         {
             parentMap.put(current.left, current);
             stack.push(current.left);
         }
     }
 }
 static void printPath(Node2 leaf, Map<Node2, Node2> parentMap) 
 {
     Stack<Integer> path = new Stack<>();
     Node2 current = leaf;
     while (current != null) 
     {
         path.push(current.data);
         current = parentMap.get(current);
     }
     while (!path.isEmpty()) 
     {
         System.out.print(path.pop());
         if (!path.isEmpty())
             System.out.print("->");
     }
     System.out.println();
 }
 public static void main(String[] args) 
 {
     Node2 root = new Node2(6);
     root.left = new Node2(3);
     root.right = new Node2(5);
     root.left.left = new Node2(2);
     root.left.right = new Node2(5);
     root.right.right = new Node2(4);
     root.left.right.left = new Node2(7);
     root.left.right.right = new Node2(4);
     printRootToLeafPaths(root);
 }
}

