class Solution {
    public String smallestPalindrome(String s) {
    int n = s.length();

    int[] freq = new int[26];

    for (int i = 0; i < n / 2; i++)
        freq[s.charAt(i) - 'a']++;

    StringBuilder left = new StringBuilder();

    for (int i = 0; i < 26; i++) {
        while (freq[i]-- > 0)
            left.append((char) ('a' + i));
    }

    if (n % 2 == 0) {
        return left.toString() +
               new StringBuilder(left).reverse().toString();
    }

    char middle = s.charAt(n / 2);

    return left.toString() +
           middle +
           new StringBuilder(left).reverse().toString();
}
}