class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[]copy = arr.clone();
        Arrays.sort(copy);
        int rank = 1;
        int[]res  = new int[arr.length];
        if(arr.length==0)
            return res;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(copy[0],rank++);
        for(int i=1;i<copy.length;i++){
            if(copy[i]!=copy[i-1]){
                map.put(copy[i],rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}