
class Main {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 0, 1};

        sortColors(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void sortColors(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
               int temp = arr[mid]; 
               arr[mid]= arr[low];
               arr[low]= temp;
               low++;
               mid++;
            }
            else if (arr[mid] == 1) {
               mid++;
            }
            else {
            int temp = arr[mid]; 
               arr[mid]= arr[high];
               arr[high]= temp;
               high--;
            }
        }
    }
}
