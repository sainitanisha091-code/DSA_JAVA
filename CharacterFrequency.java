import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        boolean[] visited = new boolean[256];

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (visited[ch] == true) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < str.length(); j++) {

                if (ch == str.charAt(j)) {
                    count++;
                }
            }

            System.out.println(ch + " -> " + count);

            visited[ch] = true;
        }

        sc.close();
    }
}
