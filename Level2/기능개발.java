import java.util.*;

class Solution {
    public int[] solution(final int[] progresses, final int[] speeds) {
        final int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }
        
        final List<Integer> releases = new ArrayList<>();
        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(days[0]);
        
        int cnt = 1;
        for (int i = 1; i < days.length; i++) {
            if (queue.peek() >= days[i]) {
                cnt++;
                continue;
            }
            queue.poll();
            queue.offer(days[i]);
            releases.add(cnt);
            cnt = 1;
        }
        releases.add(cnt);
        return releases.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}