import java.util.*;
class Solution {
    
    private static final List<List<String>> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        final Map<String, List<Airport>> graph = new HashMap<>();

        for (final String[] ticket : tickets) {
            final String from = ticket[0];
            final String to = ticket[1];
            if (!graph.containsKey(from)) {
                final List<Airport> values = new ArrayList<>();
                values.add(new Airport(to));
                graph.put(from, values);
                continue;
            }
            graph.get(from).add(new Airport(to));
            Collections.sort(graph.get(from));
        }
        dfs(graph, "ICN", new ArrayList<>());
        return answer.get(0).stream()
            .toArray(String[]::new);
    }
    
    private void dfs(Map<String, List<Airport>> graph, String now, List<String> list) {
        list.add(now);
        if (isAllVisit(graph)) {
            answer.add(new ArrayList<>(list));
        }
        final List<Airport> airports = graph.get(now);
        if (Objects.isNull(airports)) {
            return;
        }
        for (Airport airport : airports) {
            if (!airport.isVisit) {
                airport.isVisit = true;
                dfs(graph, airport.name, list);
                airport.isVisit = false;
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isAllVisit(Map<String, List<Airport>> graph) {
        for (String key : graph.keySet()) {
            final boolean flag = graph.get(key).stream()
                .allMatch(airport -> airport.isVisit);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}

class Airport implements Comparable<Airport> {

    String name;
    boolean isVisit;

    public Airport(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isVisit);
    }

    @Override
    public String toString() {
        return "Airport{" +
            "name='" + name + '\'' +
            ", isVisit=" + isVisit +
            '}';
    }

    @Override
    public int compareTo(Airport o) {
        return this.name.compareTo(o.name);
    }
}