package Assignment22;

class Node1 
{
    int data;
    Node1 left, right;
    public Node1(int item) 
    {
        data = item;
        left = right = null;
    }
}
class BinaryTreeToDLL 
{
    Node1 root;
    Node1 head; 
    Node1 prev; 
    void convertToDLL(Node1 node) 
    {
        if (node == null)
            return;
        convertToDLL(node.left);
        if (head == null)
            head = node;
        node.left = prev;
        if (prev != null)
            prev.right = node;
        prev = node;
        convertToDLL(node.right);
    }
    void printDLL(Node1 node) 
    {
        while (node != null) 
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
    public static void main(String[] args) 
    {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node1(30);
        tree.root.left = new Node1(25);
        tree.root.right = new Node1(36);
        tree.root.left.right = new Node1(12);
        tree.root.right.left = new Node1(10);
        tree.root.right.right = new Node1(15);
        tree.convertToDLL(tree.root);
        tree.printDLL(tree.head);
    }
}


