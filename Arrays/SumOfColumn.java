import java.util.Scanner;

public class Main {

    // This method finds the sum of column k
    static int sumColumn(int[][] arr, int k) {

        // Variable to store the sum
        int sum = 0;

        // Traverse all rows and access column k
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][k];
        }

        // Return the calculated sum
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the number of rows and columns
        int r = sc.nextInt();
        int c = sc.nextInt();

        // Create a 2D array with r rows and c columns
        int[][] arr = new int[r][c];

        // Take matrix elements as input
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Take the 0-based column index
        int k = sc.nextInt();

        // Calculate and print the sum of column k
        System.out.println(sumColumn(arr, k));

        sc.close();
    }
}
