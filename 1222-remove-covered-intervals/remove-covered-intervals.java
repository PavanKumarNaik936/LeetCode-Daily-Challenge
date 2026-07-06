class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0])
                return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });
        int c = 0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int currEnd = intervals[i][1];
            if(currEnd<=prevEnd){
                c++;
            }else{
                prevEnd = currEnd;
            }
        }
        return intervals.length-c;
    }
}