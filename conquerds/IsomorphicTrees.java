import java.util.Random;

public class IsomorphicTrees {

    public static void main(String[] args) {
        new IsomorphicTrees().solve();
    }

    private void solve() {
        LinkedList ll = new LinkedList();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ll.add(i);
            //ll.add(100-random.nextInt(100));
        }
        ll.print();
    }

    private class LinkedList {
        Node head;
        Node tail;
        int size;

        void add(int data) {
            Node n = new Node(data);
            if (size == 0) {
                tail = n;
            } else {
                head.ltLink = n;
            }
            if (tail == null) tail = n;
            n.rtLink = head;
            head = n;
            size++;
        }

        void reverse() {
            Node next, prev = null;
            Node current = head;
            while (current != null) {
                next = current.rtLink;
                current.rtLink = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        void print() {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "->");
                tmp = tmp.rtLink;
            }
            System.out.println("null");
        }

        @Override
        public String toString() {
            return super.toString();
        }

        private class Node {
            int data;
            Node rtLink;
            Node ltLink;

            Node(int data) {
                this.data = data;
            }
        }
    }
}
