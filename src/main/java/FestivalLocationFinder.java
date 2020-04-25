import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FestivalLocationFinder {
    public int find(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
        List<Point> points = new ArrayList<>();
        IndexToPoint indexToPoint = new IndexToPoint();

        int maxX = x.stream().max(Integer::compareTo).orElse(0);
        int maxY = y.stream().max(Integer::compareTo).orElse(0);

        for (int i = 0; i <= maxX; i++) {
            indexToPoint.createIfAbsent(i);
            for (int j = 0; j <= maxY; j++) {
                Point point = new Point(i, j);
                points.add(point);
                indexToPoint.putIfAbsent(i, j, point);
            }
        }
        IntStream.range(0, numPeople.size()).forEach(index -> indexToPoint.get(x.get(index)).get(y.get(index)).incrementNumberOfPeopleAtPoint(numPeople.get(index)));

        return getCheapestLocation(points);
    }

    private int getCheapestLocation(List<Point> points) {
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