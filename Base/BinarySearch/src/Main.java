public class Main {

    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5};
        int x = binarySearch(ints, 0, ints.length - 1, 2);

        System.out.println(x);
        System.out.println("Hello World!");
    }

    static int binarySearch(int[] arr, int low, int high, int target) {

        if (arr.length <= 0 || low < 0 || high >= arr.length) {
            return -1;
        }

        while (low < high) {

            int mid = (low + high) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return -1;
    }
}
