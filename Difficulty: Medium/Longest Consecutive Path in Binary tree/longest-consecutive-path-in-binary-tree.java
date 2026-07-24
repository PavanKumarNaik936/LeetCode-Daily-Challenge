/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int ans = 1;
    public int longestConsecutive(Node root) {
    if (root == null) return -1;

        dfs(root);

        return ans == 1 ? -1 : ans;
    }
    private int dfs(Node root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int curr = 1;

        if (root.left != null && root.left.data == root.data + 1) {
            curr = Math.max(curr, 1 + left);
        }

        if (root.right != null && root.right.data == root.data + 1) {
            curr = Math.max(curr, 1 + right);
        }

        ans = Math.max(ans, curr);

        return curr;
    }
}