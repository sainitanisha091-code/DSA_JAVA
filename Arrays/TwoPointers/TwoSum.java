import java.util.*;

public class Main {

    static boolean twoSum(int[] arr, int target) {
         int i = 0 ;
         int j = arr.length-1;
                while (i<j){
                    int sum = arr[i]+arr[j];
                    if(sum==target){
                        return true;
                    }
                    else if (sum<target){
                        i++;
                    }
                    else {
                        j--;
                    }
                }
            
        
             return false;
    
        } 

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 6};
        int target = 12;

        boolean result = twoSum(arr, target);

        System.out.println(result);
    }
}
