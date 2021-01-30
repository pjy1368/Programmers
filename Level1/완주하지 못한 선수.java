import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();
        Arrays.stream(participant)
            .forEach(i -> {
              participantMap.put(i, participantMap.getOrDefault(i, 0) + 1);
            });

        Arrays.stream(completion)
            .forEach(i -> {
              participantMap.put(i, participantMap.get(i) - 1);
            });

        answer = participantMap.keySet()
            .stream()
            .filter(key -> participantMap.get(key) != 0)
            .findFirst()
            .orElse("");
        return answer;
    }
}