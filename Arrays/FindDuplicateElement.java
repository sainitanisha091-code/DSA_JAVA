import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int []arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i]= sc.nextInt();
        }
        boolean visited[] = new boolean[256];
        for (int i = 0 ; i < n; i++){
            if(visited[arr[i]]){
                System.out.println(arr[i]);
                break;
            }
        
        visited[arr[i]]= true;
        }
        sc.close();
    }
}
