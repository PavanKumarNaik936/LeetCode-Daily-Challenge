class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[]arr = nums.clone();
        Arrays.sort(arr);
        HashMap<Integer,Integer>mapToGroup = new HashMap<>();
        HashMap<Integer,LinkedList<Integer>>groupToList = new HashMap<>();
        int groupNum = 0;
        mapToGroup.put(arr[0],groupNum);
        groupToList.put(groupNum,new LinkedList<Integer>());
        groupToList.get(groupNum).addLast(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]>limit){
                groupNum++;
            }
            mapToGroup.put(arr[i],groupNum);
            if(!groupToList.containsKey(groupNum))
                groupToList.put(groupNum,new LinkedList<Integer>());
            groupToList.get(groupNum).addLast(arr[i]);
        }
        
        int[]res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int grp = mapToGroup.get(nums[i]);
            res[i] = groupToList.get(grp).removeFirst();
        }
        return res;
    }
}