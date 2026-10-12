class BusBooking {
    int n;
    boolean[][]seats;
    int[][]bookingCost;
    int totalTime;
    int totalBookedSeats;
    public BusBooking(int n) {
        this.n = n;
        seats = new boolean[n][4];
        bookingCost = new int[n][4];
        totalTime = 0;
        totalBookedSeats = 0;
    }
    
    public void toggle(String seat) {
        char letter = seat.charAt(0);
        int row = Integer.valueOf(seat.substring(1,seat.length()))-1;
        int col = letter-'A';
        if(seats[row][col]){
            //already booked seat : need to free
            totalTime-=bookingCost[row][col];
            totalBookedSeats--;
            bookingCost[row][col]=0;
            seats[row][col]=false;
        }else{
            //book the seat
            int cost=1;
            if(col==0 && seats[row][1])
                cost=3;
            if(col==3 && seats[row][2])
                cost=3;
            seats[row][col]=true;
            bookingCost[row][col]+=cost;
            totalTime+=cost;
            totalBookedSeats++;
        }

    }
    
    public int getTotalTime() {
        return totalTime;
    }
    
    public int getMinTime() {
        return totalBookedSeats;
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */