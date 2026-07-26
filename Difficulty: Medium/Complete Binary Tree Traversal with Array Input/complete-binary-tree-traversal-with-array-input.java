class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        int size = 1;
        int i = 0;
        while(i<arr.length){
            ArrayList<Integer>list = new ArrayList<>();
            int tempSize = size;
            while(size>0 && i<arr.length){
                list.add(arr[i]);
                i++;
                size--;
            }
            Collections.sort(list);
            res.add(list);
            size =tempSize*2;
        }
        return res;
    }
}