import java.util.*;

public class Main {

    static int countPairsWithSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                count++;
                left++;
                right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6};
        int target = 7;

        int result = countPairsWithSum(arr, target);

        System.out.println(result);
    }
}
