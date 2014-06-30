package sorting;

//	I N S E R T I O N 

//	I N
//	I N S
//	E I N S
//	E I N R S
//	E I N R S T

//	start from the 2nd element in the array moving to the last
//     (the 1st element in itself is already sorted and so we need not pick it for sorting)

//	pick the next element 'n' in the array
// 		the sub array that needs sorting now is array[0]-array[n]
//		insert the nth element in its correct position in this sub array
//			inserting works by swapping adjacent elements

public class InsertionSort {
    public static void sort(int array[]) {
        for(int i=1; i<array.length; i++) {
            for(int j=i; j>0 && array[j] > array[j-1]; j--) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,5,4,3,2,1,0};
        InsertionSort.sort(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");

        System.out.println();
    }
}


