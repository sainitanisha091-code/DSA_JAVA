import java.util.Scanner;

public class Main {

    // This method finds the sum of both diagonals
    static int diagonalSum(int[][] arr) {

        // Variable to store the diagonal sum
        int sum = 0;

        // Traverse all elements of the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                // Check if the element belongs to either diagonal
                if (i == j || i + j == arr.length - 1) {
                    sum += arr[i][j];
                }
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

        // Calculate and print the sum of both diagonals
        System.out.println(diagonalSum(arr));

        sc.close();
    }
}
