class Solution {
    int minSubsets(int arr[]) {
        // code here
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int x:arr){
            map.put(x,0);
        }
        int c = 0;
        for(Integer start:map.keySet()){
            int key = start;
            while(map.containsKey(key-1) && map.get(key-1)==0){
                key--;
            }
            if(map.get(key)==1)continue;
            while(map.containsKey(key) && map.get(key)==0){
                map.put(key,1);
                key++;
            }
            c++;
        }
        return c;
    }
}