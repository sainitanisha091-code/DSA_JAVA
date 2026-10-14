
public class MinimumSumSubarray {

    static int minSum(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            throw new IllegalArgumentException("Invalid array or window size");
        }

        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int minSum = sum;

        for (int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(minSum(arr, k));
    }
}
