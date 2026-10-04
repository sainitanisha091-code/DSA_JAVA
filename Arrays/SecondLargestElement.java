static int secondLargest(int[] arr) {

    int max_1 = Integer.MIN_VALUE;
    int max_2 = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] > max_1) {
            max_2 = max_1;
            max_1 = arr[i];
        }
        else if (arr[i] > max_2 && arr[i] != max_1) {
            max_2 = arr[i];
        }
    }

    return max_2;
}
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(secondLargest(arr));

        sc.close();
    }
}
