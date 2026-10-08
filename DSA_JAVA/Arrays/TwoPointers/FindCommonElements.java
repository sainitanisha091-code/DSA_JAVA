public class Main {

    static int[] findCommon(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[Math.min(arr1.length, arr2.length)];
        while (i<arr1.length && j < arr2.length){
            if (arr1[i]<arr2[j]){
                i++;
            }
            else if (arr1[i]>arr2[j]){
                j++;
            }
            else if(arr1[i]==arr2[j]){
                result[k]= arr1[i];
                k++;
                i++;
                j++;
            }
        }

        return java.util.Arrays.copyOf(result, k);
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 4, 5, 7};
        int[] arr2 = {2, 3, 5, 6, 7};

        int[] result = findCommon(arr1, arr2);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
