import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class FestivalLocationFinder {
    public int find(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
        List<Point> points = new ArrayList<>();
        Map<Integer, Map<Integer, Point>> indexToPoint = new HashMap<>();

        int maxX = x.stream().max(Integer::compareTo).get();
        int maxY = y.stream().max(Integer::compareTo).get();

        for (int i = 0; i <= maxX; i++) {
            indexToPoint.putIfAbsent(i, new HashMap<>());
            for (int j = 0; j <= maxY; j++) {
                Point point = new Point(i, j);
                points.add(point);
                indexToPoint.get(i).putIfAbsent(j, point);
            }
        }
        IntStream.range(0, numPeople.size()).forEach(index -> indexToPoint.get(x.get(index)).get(y.get(index)).numberOfPeopleAtPoint += numPeople.get(index));

        int min = Integer.MAX_VALUE;
        for (Point point : points) {
            int costForPoint = 0;
            for (Point otherPoint : points) {
                if (costForPoint > min) { break; }
                costForPoint += point.getCostForPoint(otherPoint);
            }
            if (costForPoint < min) {
                min = costForPoint;
            }
        }

        return min;
    }
}

class Point {
    final int x;
    final int y;
    int numberOfPeopleAtPoint;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getCostForPoint(Point otherPoint) {
        return getDistance(otherPoint)*otherPoint.numberOfPeopleAtPoint;
    }

    private int getDistance(Point otherPoint) {
        return Math.abs(otherPoint.x - this.x) + Math.abs(otherPoint.y - this.y);
    }
}