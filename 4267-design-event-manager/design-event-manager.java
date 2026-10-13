class EventManager {
    class Pair{
        int priority;
        int eventId;
        Pair(int priority,int eventId){
            this.priority = priority;
            this.eventId = eventId;
        }
    }
    PriorityQueue<Pair>maxHeap;
    HashMap<Integer,Integer>currentPriority;
    public EventManager(int[][] events) {
        currentPriority = new HashMap<>();
        maxHeap = new PriorityQueue<Pair>((a,b)->{
            if(b.priority!=a.priority)
                return Integer.compare(b.priority,a.priority);
            return Integer.compare(a.eventId,b.eventId);
        });
        for(int[]event:events){
            maxHeap.offer(new Pair(event[1],event[0]));
            currentPriority.put(event[0],event[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        currentPriority.put(eventId,newPriority);
        maxHeap.offer(new Pair(newPriority,eventId));
    }
    
    public int pollHighest() {
        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.poll();
            Integer priority = currentPriority.get(p.eventId);
            if(priority!=null && priority==p.priority){
                currentPriority.remove(p.eventId);
                return p.eventId;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */