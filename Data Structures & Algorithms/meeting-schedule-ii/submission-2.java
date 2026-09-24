class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval interval : intervals) {

   
            if (!pq.isEmpty() && pq.peek() <= interval.start) {
                pq.poll();
            }

            pq.offer(interval.end);
        }

        return pq.size();
    }
}