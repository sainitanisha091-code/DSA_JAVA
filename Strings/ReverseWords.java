import java.util.Scanner;

class Solution {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {

            if (i + 1 < sb.length() &&
                sb.charAt(i) == '.' &&
                sb.charAt(i + 1) == '.') {

                sb.deleteCharAt(i);
                i--;
            }
        }

        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        String[] word = sb.toString().trim().split("\\.");

        for (int i = word.length - 1; i >= 0; i--) {

            result.append(word[i]);

            if (i != 0) {
                result.append('.');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take the string as input
        String s = sc.nextLine();

        // Create Solution object
        Solution obj = new Solution();

        // Call the method and print the result
        System.out.println(obj.reverseWords(s));

        sc.close();
    }
}
