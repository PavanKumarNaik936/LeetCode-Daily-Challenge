class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c = 0;
        for(int i=0;i<arr1.length;i++){
            boolean flag = true;
            for(int j=0;j<arr2.length;j++){
                int distance = Math.abs(arr1[i]-arr2[j]);
                if(distance<=d)
                    flag = false;
            }
            if(flag)
                c++;
        }
        return c;
    }
}