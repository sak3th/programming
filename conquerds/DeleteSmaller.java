/**
 * Given a singly linked list, remove all the nodes which have a greater value on right side.
 * Examples:
 * a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. Note that
 *    12, 10, 5 and 2 have been deleted because there is a greater value on the right side.
 * b) The list 10->20->30->40->50->60->NULL should be changed to 60->NULL. Note that 10, 20, 30,
 *    40 and 50 have been deleted because they all have a greater value on the right side.
 * c) The list 60->50->40->30->20->10->NULL should not be changed.
 *
 * Time Complexity: O(n)
 */

import java.util.Random;

public class DeleteSmaller {

    public static void main(String[] args) {
        new DeleteSmaller().solve();
    }

    private void solve() {
        LinkedList ll = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ll.add(i);
            //ll.add(100-random.nextInt(100));
        }
        ll.print();
        ll.deleteSmaller();
        ll.print();
    }

    private class LinkedList {
        Node head;
        int size;

        void add(int data) {
            Node n = new Node(data);
            n.link = head;
            head = n;
            size++;
        }

        void reverse() {
            Node next, prev = null;
            Node current = head;
            while (current != null) {
                next = current.link;
                current.link = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        void deleteSmaller() {
            if (size < 2) return;
            reverse();
            Node prev = head;
            int max = prev.data;
            Node current = prev.link;
            while (current != null) {
                if (current.data < max) {
                    prev.link = current.link;
                } else {
                    max = current.data;
                    prev = current;
                }
                current = current.link;
            }
            reverse();
        }

        void print() {
            Node tmp = head;
             while (tmp != null) {
                 System.out.print(tmp.data + "->");
                 tmp = tmp.link;
             }
             System.out.println("null");
        }

        private class Node {
            int data;
            Node link;

            Node(int data) {
                this.data = data;
            }
        }
    }
}
