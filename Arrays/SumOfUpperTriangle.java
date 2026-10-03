import java.util.Scanner;

public class Main {

    // This method finds the sum of the upper triangular part of the matrix
    static int sumUpperTriangle(int[][] arr) {

        // Variable to store the sum
        int sum = 0;

        // Traverse each row
        for (int i = 0; i < arr.length; i++) {

            // Start from the diagonal element and move right
            for (int j = i; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
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

        // Calculate and print the sum of the upper triangular part
        System.out.println(sumUpperTriangle(arr));

        sc.close();
    }
}
