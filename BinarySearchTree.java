class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    // Constructor to initialize the root
    BinarySearchTree() {
        root = null;
    }

    // Function to insert a new value in the BST
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value in the BST
    Node insertRec(Node root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        // Return the unchanged root node
        return root;
    }

    // Function to delete a value from the BST
    void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive function to delete a value from the BST
    Node deleteRec(Node root, int value) {
        // If the tree is empty
        if (root == null) return root;

        // Otherwise, recur down the tree
        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);

        // If the value is the same as root's value, this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    // Function to find the minimum value in a tree
    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    // Function to search for a value in the BST
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function to search for a value in the BST
    boolean searchRec(Node root, int value) {
        // Base Cases: root is null or value is present at root
        if (root == null || root.value == value)
            return root != null;

        // Value is greater than root's value
        if (value > root.value)
            return searchRec(root.right, value);

        // Value is smaller than root's value
        return searchRec(root.left, value);
    }

    // Function to print the inorder traversal of the BST
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    // Recursive function for inorder traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}

// Driver code to test the BST implementation
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        // Search for elements in the BST
        System.out.println("Search 60 in BST: " + bst.search(60));
        System.out.println("Search 90 in BST: " + bst.search(90));

        // Delete elements from the BST
        System.out.println("Deleting 20, 30, and 50 from BST");
        bst.delete(20);
        bst.delete(30);
        bst.delete(50);

        // Print inorder traversal of the modified BST
        System.out.println("Inorder traversal after deletions:");
        bst.inorder();
    }
}
