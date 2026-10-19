
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // Step 1: Calculate the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Step 2: Initialize the maximum average using the first window
        double maxAverage = sum / k;

        // Step 3: Slide the window by one element at a time
        for (int i = 0; i < nums.length - k; i++) {

            // Remove the outgoing element and add the incoming element
            sum = sum - nums[i] + nums[i + k];

            // Calculate the current window's average
            double currentAverage = sum / k;

            // Update the maximum average if the current average is greater
            if (maxAverage < currentAverage) {
                maxAverage = currentAverage;
            }
        }

        // Step 4: Return the maximum average found
        return maxAverage;
    }
}
