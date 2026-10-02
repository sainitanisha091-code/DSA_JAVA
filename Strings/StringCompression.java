import java.util.Scanner;

public class Main {

    // This method compresses the string
    static String compress(String str) {

        // To store the final answer
        StringBuilder result = new StringBuilder();

        // Go through each character
        for (int i = 0; i < str.length(); i++) {

            // Start count from 1
            int count = 1;

            // Count same characters together
            for (; i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1);) {
                count++;
                i++;
            }

            // If character comes more than once
            if (count > 1) {
                result.append(str.charAt(i)).append(count);
            }
            else {
                // If character comes only once
                result.append(str.charAt(i));
            }
        }

        // Return the final string
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        String str = sc.next();

        // Call the method and print answer
        System.out.println(compress(str));

        sc.close();
    }
}
