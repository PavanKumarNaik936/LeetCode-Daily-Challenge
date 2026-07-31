import java.util.*;

class Solution {

    static final int MOD = 1000000007;
    int[] mask = new int[31];

    public Solution() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int i = 2; i <= 30; i++) {

            // Skip numbers having squared prime factors
            if (i % 4 == 0 || i % 9 == 0 || i == 25)
                continue;

            int m = 0;
            for (int j = 0; j < 10; j++) {
                if (i % primes[j] == 0)
                    m |= (1 << j);
            }
            mask[i] = m;
        }
    }

    long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                ans = (ans * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }

    public int countSubsets(int[] arr) {

        int[] freq = new int[31];
        int ones = 0;

        for (int x : arr) {
            if (x == 1)
                ones++;
            else if (mask[x] != 0)
                freq[x]++;
        }

        long[] dp = new long[1024];
        dp[0] = 1;

        for (int num = 2; num <= 30; num++) {

            if (freq[num] == 0)
                continue;

            int m = mask[num];

            for (int state = 1023; state >= 0; state--) {

                if ((state & m) != 0)
                    continue;

                dp[state | m] =
                        (dp[state | m] + dp[state] * freq[num]) % MOD;
            }
        }

        long ans = 0;

        for (long x : dp)
            ans = (ans + x) % MOD;

        ans = (ans - 1 + MOD) % MOD; // remove empty subset

        ans = (ans * power(2, ones)) % MOD;

        return (int) ans;
    }
}