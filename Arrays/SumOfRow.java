import java.util.Scanner;

public class Main {

    // This method finds the sum of row k
    static int sumRow(int[][] arr, int k) {

        // Store the sum
        int sum = 0;

        // Go through all columns of row k
        for (int j = 0; j < arr[k].length; j++) {
            sum += arr[k][j];
        }

        // Return the sum
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of rows and columns
        int r = sc.nextInt();
        int c = sc.nextInt();

        // Create the 2D array
        int[][] arr = new int[r][c];

        // Take matrix input
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Take the row number
        int k = sc.nextInt();

        // Find and print the sum of row k
        System.out.println(sumRow(arr, k));

        sc.close();
    }
}
