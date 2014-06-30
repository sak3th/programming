package basics;

/**
 * Java manipulates objects 'by reference,' but it passes object references to methods 'by value'.
 * As a result, you cannot write a standard swap method to swap objects.
 */
public class PassByReference {

    public static void main(String[] args) {
        int A = 5, B = 10;
        System.out.println("A = " + A + ", B = " + B);
        swap(A, B);
        System.out.println("Swap (primitive data type): " + "A = " + A + ", B = " + B);

        Integer a = new Integer(5);
        Integer b = new Integer(10);
        swap(a, b); //a = 10;
        System.out.println("Swap (objects): " + "A = " + a + ", B = " + b);

        PassByReference five = new PassByReference(5);
        PassByReference ten = new PassByReference(10);
        swap(five, ten);
        System.out.println("Swap (objects, but??): " + "A = " + five + ", B = " + ten);
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void swap(Integer a, Integer b) {
        Integer temp = new Integer(a);
        a = b;
        b = temp;
        b = a;
    }

    static void swap(PassByReference a, PassByReference b) {
        PassByReference temp = new PassByReference(a.value);
        a.value = b.value;
        b.value = temp.value;
    }

    int value;

    PassByReference(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
