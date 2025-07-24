package gr.uop;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VotingCountry {
    private String name;
    private Map<String, Integer> pointsTo = new LinkedHashMap<>();

    public VotingCountry(String name, Map<String, Integer> pointsTo) {
        this.name = name;
        this.pointsTo = pointsTo;
    }

    public void setPointsTo(String country, int points) {
        pointsTo.put(country, points);
    }

    public int getPointsTo(String country) {
        Integer points = pointsTo.get(country);
        if (points > 0)
            return points;
        else
            return 0;
    }

    public void printAllPoints() {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(pointsTo.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.println(entry.getKey() + "\t\t\t\t " + entry.getValue());
            }
        }
        pointsTo.clear();
    }
}
