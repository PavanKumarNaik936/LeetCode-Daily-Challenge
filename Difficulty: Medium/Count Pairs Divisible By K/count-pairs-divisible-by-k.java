class Solution {
    public int countKdivPairs(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer>map = new HashMap<>();
        int c = 0;
        for(int i=0;i<arr.length;i++){
            int rem = arr[i]%k;
            int need = (k-rem)%k;
            if(map.containsKey(need)){
                c+=map.get(need);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return c;
    }
}