/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0){
            return 0;
        }
          Collections.sort(intervals,(a,b)->{
             if(a.start==b.start)return a.end-b.end;
             return a.start-b.start;
          });
          int s = intervals.get(0).start;
          int e = intervals.get(0).end;

          int count = 1;

          for(int i=1;i<intervals.size();i++){
            int cs = intervals.get(i).start;
            int ce = intervals.get(i).end;
            if(e>cs){
                count++;
                e=Math.min(e,ce);
            }else{
                e=ce;
                s=cs;
            }

          }


          return count;
    }
}














