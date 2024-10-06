import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        String result = Arrays.toString(arr);
        System.out.println(result); //[1, 5, 3, 4, 2]

        int index = Arrays.binarySearch(arr, 3);
        System.out.println(index);  // 2

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        boolean check = Arrays.equals(arr1, arr2);
        System.out.println(check);  // true

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));  // [1, 2, 3, 4, 5]
    }
}
