package Subject04;

public class BinarySearch implements Searcher {

    @Override
    public int search(int[] arr, int iKey) {
        int mid;
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            mid = (right + left) / 2;

            if (iKey == arr[mid]) {
                System.out.println(iKey + " is in the array with index value: " + mid);
                return mid;
            }

            if (iKey < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return 0;
    }
}