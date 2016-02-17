package trees;

public class BinarySearchTree {

    BSTNode root;

    void insert(int data) {
        BSTNode node = new BSTNode(data);
        root = (root == null)? node : insert(node, root);
    }
    /** returns the root */
    private BSTNode insert(BSTNode node, BSTNode root) {
        if (root == null) return node;
        if (node.data < root.data) root.left = insert(node, root.left);
        else root.right = insert(node, root.right);
        return root;
    }
}

class BSTNode {
    int data;
    BSTNode left, right;
    BSTNode(int d) { data = d; }
}