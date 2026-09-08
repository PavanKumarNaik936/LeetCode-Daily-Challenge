class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int groups = 0;
        int nextSpeed = -1;
        int nextPos = -1;
        for(int i=speed.length-1;i>=0;i--){
            if(i==speed.length-1 || speed[i]<=nextSpeed && position[i+1]-position[i]>distance){
                groups++;
                nextSpeed = speed[i];
                nextPos = position[i];
            }
        }
        return groups;
    }
}