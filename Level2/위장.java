import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        final Map<String, List<String>> map = new HashMap<>();
        for (final String[] cloth : clothes) {
            final String name = cloth[0];
            final String kind = cloth[1];
            if (!map.containsKey(kind)) {
                final List<String> names = new ArrayList<>();
                names.add(name);
                map.put(kind, names);
            } else {
                map.get(kind).add(name);
            }
        }
        final List<Integer> kinds = new ArrayList<>();
        map.forEach((kind, name) -> kinds.add(name.size() + 1));
        return kinds.stream()
            .mapToInt(Integer::intValue)
            .reduce(1, (x, y) -> x * y) - 1;
    }
}