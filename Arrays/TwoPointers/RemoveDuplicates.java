public class Main {

    static int removeDuplicates(int[] arr) {

        int slow = 0 ; 
        for (int fast= 0 ; fast < arr.length ; fast++){
            if (arr[slow]!=arr[fast]){
                slow++;
                arr[slow]=arr[fast];
            }
        }
        return slow+1;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3,4};

        int length = removeDuplicates(arr);

        System.out.println("Length = " + length);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
