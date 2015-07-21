package trees;


public class Traversal {

    public static void main(String[] args) {
        Traversal t = new Traversal();
        Node d = new Node('D', null, null);
        Node e = new Node('E', null, null);
        Node g = new Node('G', null, null);
        Node h = new Node('H', null, null);
        Node b = new Node('B', d, e);
        Node f = new Node('F', g, h);
        //Node c = new Node('C', f, null);
        Node c = new Node('C', null, f);
        Node a = new Node('A', b, c);

        System.out.print("Preorder:"); t.preorder(a); System.out.println();
        System.out.print("Inorder:"); t.inorder(a); System.out.println();
        System.out.print("Postorder:"); t.postorder(a); System.out.println();
    }

    void preorder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            if (node.left != null) preorder(node.left);
            if (node.right != null) preorder(node.right);
        }
    }

    void inorder(Node node) {
        if (node != null) {
            if (node.left != null) inorder(node.left);
            System.out.print(" " + node.value);
            if (node.right != null) inorder(node.right);
        }
    }

    void postorder(Node node) {
        if (node != null) {
            if (node.left != null) postorder(node.left);
            if (node.right != null) postorder(node.right);
            System.out.print(" " + node.value);
        }
    }
}

class Node {
    Node left, right;
    char value;
    public Node(char value, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}