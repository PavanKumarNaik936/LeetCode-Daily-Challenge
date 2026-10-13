class RideSharingSystem {
    Queue<Integer>rider;
    Queue<Integer>driver;
    Set<Integer>riderMap;
    public RideSharingSystem() {
        rider = new LinkedList<Integer>();
        driver = new LinkedList<Integer>();
        riderMap = new HashSet<Integer>();
    }
    
    public void addRider(int riderId) {
        rider.offer(riderId);
        riderMap.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if(rider.size()>0 && driver.size()>0){
            int r = rider.poll();
            int d = driver.poll();
            int[]result = {d,r};
            riderMap.remove(r);
            return result;
        }
        return new int[]{-1,-1};
    }
    
    public void cancelRider(int riderId) {
        if(riderMap.contains(riderId)){
            rider.remove(riderId);
            riderMap.remove(riderId);
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */