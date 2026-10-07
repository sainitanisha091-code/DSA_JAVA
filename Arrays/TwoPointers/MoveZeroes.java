public class Main {

    static void moveZeroes(int[] arr) {

        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {

            if (arr[fast] != 0) {
                arr[slow] = arr[fast];
                slow++;
            }
        }

        while (slow < arr.length) {
            arr[slow] = 0;
            slow++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 3, 0, 4};

        moveZeroes(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
