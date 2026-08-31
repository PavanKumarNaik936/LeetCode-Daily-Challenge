/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        ListNode curr = head;
        ListNode prev = null;
        ArrayList<Integer>criticalPoints = new ArrayList<>();
        int c = 0;
        while(curr!=null){
            c++;
            ListNode temp = curr.next;
            if(prev!=null && temp!=null){
                //local minima
                if(curr.val<prev.val && curr.val<temp.val){
                    criticalPoints.add(c);
                }
                //local maxima
                else if(curr.val>prev.val && curr.val>temp.val){
                    criticalPoints.add(c);
                }
            }
            
            prev = curr;
            curr = temp;
        }
        if(criticalPoints.size()<2)
            return new int[]{-1,-1};
        
        for(int i=1;i<criticalPoints.size();i++){
            minDistance = Math.min(minDistance,criticalPoints.get(i)-criticalPoints.get(i-1));
        }
        maxDistance = criticalPoints.get(criticalPoints.size()-1)-criticalPoints.get(0);
        return new int[]{minDistance,maxDistance};
        
    }
}