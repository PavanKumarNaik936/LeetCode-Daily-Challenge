/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Data{
        int sum;
        int n;
        int cnt;
        Data(int sum,int n,int cnt){
            this.sum = sum;
            this.n = n;
            this.cnt = cnt;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        return find(root).cnt;
    }
    public Data find(TreeNode root){
        if(root==null)
            return new Data(0,0,0);
        Data left = find(root.left);
        Data right = find(root.right);
        int newSum = left.sum+right.sum+root.val;
        int newN = left.n+right.n+1;
        int newCnt = left.cnt+right.cnt;
        int avg =0;
        if(newN!=0)
            avg = newSum/newN;
        if(avg==root.val)
            newCnt+=1;
        
        return new Data(newSum,newN,newCnt);
    }
}