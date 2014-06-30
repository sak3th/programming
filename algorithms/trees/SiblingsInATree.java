package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SiblingsInATree {

    public static void main(String[] args) {
        Node a = new Node(8);
        Node b = new Node(3);
        Node c = new Node(10);
        Node d = new Node(1);
        Node e = new Node(6);
        Node f = new Node(14);
        Node g = new Node(4);
        Node h = new Node(7);
        Node i = new Node(13);
        Node j = new Node(15);
        Node k = new Node(16);
        
        a.left = b; a.right = c;
        b.left = d; b.right = e;
                    c.right = f;
        e.left = g; e.right = h;
        f.left = i;
        d.left = j;
        i.right = k;
        
        findSiblings(a);
    }

    static void findSiblings(Node head) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(head);
        queue.add(null);

        Node prev, next = null;
        while (!queue.isEmpty()) {
            prev = queue.poll();
            while (prev != null) {
                if(prev.left != null) queue.add(prev.left);
                if(prev.right != null) queue.add(prev.right);
                next = queue.poll();
                prev.sibling = next;
                if(next != null) out(prev.data + "->" + next.data + " ");
                prev = next;
            }
            if(queue.size() != 0) queue.add(null);
            outln("");
        }
    }

    static class Node {
        Node left, right, sibling;
        int data;

        Node(int data) {this.data = data;}
    }

    static void out(String str) {
        System.out.print(str);
    }

    static void outln(String str) {
        System.out.println(str);
    }
}
