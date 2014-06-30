package datastructures;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        Tree root = bst.insert(6);
        bst.insert(10);
        bst.insert(8);
        bst.insert(7);
        bst.insert(9);
        bst.insert(4);
        bst.insert(5);
        bst.insert(3);
        bst.traverse(BinarySearchTree.IN_ORDER);
        bst.traverse(BinarySearchTree.POST_ORDER);
        out("\n");
        //out(findMinimum(root).data + "\n");
        //out(findMaximum(root).data + "\n");
        //out(search(root, 5).data + "\n");
        //out(search(root, 7).data + "\n");
        bst.delete(6);
        bst.traverse(BinarySearchTree.IN_ORDER);
        out("\n");
        bst.delete(5);
        bst.traverse(BinarySearchTree.IN_ORDER);
        out("\n");
        bst.delete(4);
        bst.traverse(BinarySearchTree.IN_ORDER);
        out("\n");
        bst.delete(10);
        bst.traverse(BinarySearchTree.IN_ORDER);
        out("\n");
    }

    public static final int IN_ORDER  = 1;
    public static final int PRE_ORDER  = 2;
    public static final int POST_ORDER  = 3;

    private Tree root;

    /* O(h) where h is height of the tree */
    public Tree search(Tree node, int x) {
        if (root == null) return null;
        if (x == root.data) return root;
        if (x < root.data) return search(root.left, x);
        else return search(root.right, x);
    }

    public Tree findMinimum() {
        if (root == null) return null;
        Tree min = root;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public Tree findMaximum() {
        if (root == null) return null;
        Tree max = root;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    public void traverse(int order) {
        if (root == null) return;
        traverse(root, order);
    }

    private void traverse(Tree node, int order) {
        if (root == null) return;
        if (order == PRE_ORDER) processNode(root);
        traverse(root.left, order);
        if (order == IN_ORDER) processNode(root);
        traverse(root.right, order);
        if (order == POST_ORDER) processNode(root);
    }

    /* left most child in right subtree */
    public Tree successor(Tree node) {
        if (node == null || node.right == null) return null;
        Tree tmp = node.right;
        while (tmp.left != null) tmp = tmp.left;
        return tmp;
    }

    /* right most child in left subtree */
    public Tree predecessor(Tree node) {
        if (node == null || node.left == null) return null;
        Tree tmp = node.left;
        while (tmp.right != null) tmp = tmp.right;
        return tmp.right;
    }

    public Tree insert(int x) {
        return insert(root, x, null);
    }

    public Tree insert(Tree node, int x, Tree parent) {
        if (root == null) {
            Tree tree = new Tree(x);
            tree.left = tree.right = null;
            tree.parent = parent;
            if (parent != null) {
                if (x < parent.data) parent.left = tree;
                else parent.right = tree;
            }
            root = tree;
            return tree;
        }
        if (x < root.data) return insert(root.left, x, root);
        else return insert(root.right, x, root);
    }

    public boolean delete(int x) {
        Tree node = search(root, x);
        if (node == null) return false;
        Tree parent = node.parent;
        Tree delNode = null;

        if (parent == null) { /* root node */
            if (node.left == null && node.right == null) { /* root only tree */
                root = null;
                return true;
            } else {
                if (node.left != null) delNode = predecessor(node);
                else delNode = successor(node);
            }
        } else { /* non root node */
            if (node.left != null && node.right != null) { /* both left and right children exist */
                delNode = successor(node);
            } else if (node.left != null || node.right != null) { /* only a single child exists */
                if (node.left != null) delNode = node.left;
                else delNode = node.right;
            } else { /* no children */

            }
        }

        delete(delNode.data);
        node.data = delNode.data;
        return true;
    }

    private static void processNode(Tree tree) {
        out(tree.data + " ");
    }

    private static void out(String str) {
        System.out.print(str);
    }
}
