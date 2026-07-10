class Solution {
    public int getCount(int n) {
        int count = 0;

        for (int k = 2; k * (k - 1) / 2 < n; k++) {
            int rem = n - k * (k - 1) / 2;
            if (rem % k == 0 && rem / k >= 1) {
                count++;
            }
        }

        return count;
    }
}