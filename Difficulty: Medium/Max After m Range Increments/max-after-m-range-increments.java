class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {

        int[] diff = new int[n + 1];

        for (int i = 0; i < a.length; i++) {
            diff[a[i]] += k[i];

            if (b[i] + 1 < n)
                diff[b[i] + 1] -= k[i];
        }

        int max = diff[0];
        int curr = diff[0];

        for (int i = 1; i < n; i++) {
            curr += diff[i];
            max = Math.max(max, curr);
        }

        return max;
    }
}