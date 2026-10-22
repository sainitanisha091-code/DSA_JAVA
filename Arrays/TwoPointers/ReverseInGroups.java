
import java.util.Arrays;

class Solution {
    public void reverseInGroups(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return;
        }

        for (int start = 0; start < arr.length; start += k) {
            int end = Math.min(start + k - 1, arr.length - 1);

            int left = start;
            int right = end;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        Solution solution = new Solution();
        solution.reverseInGroups(arr, k);

        System.out.println(Arrays.toString(arr));
    }
}
