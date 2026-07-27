/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    HashMap<Integer, Integer> pos;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {

        pos = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            pos.put(preMirror[i], i);
        }

        return build(pre, 0, pre.length - 1,
                     preMirror, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int preL, int preR,
                       int[] mirror, int mirL, int mirR) {

        if (preL > preR)
            return null;

        Node root = new Node(pre[preL]);

        if (preL == preR)
            return root;

        int leftRoot = pre[preL + 1];
        int idx = pos.get(leftRoot);

        // Number of nodes in right subtree
        int rightSize = idx - mirL - 1;

        // Number of nodes in left subtree
        int leftSize = preR - preL - rightSize;

        root.right = build(pre,
                           preR - rightSize + 1,
                           preR,
                           mirror,
                           mirL + 1,
                           idx - 1);

        root.left = build(pre,
                          preL + 1,
                          preL + leftSize,
                          mirror,
                          idx,
                          mirR);

        return root;
    }
}