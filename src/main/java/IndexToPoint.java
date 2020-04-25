import java.util.HashMap;
import java.util.Map;

public class IndexToPoint {
    private Map<Integer, Map<Integer, Point>> indexToPoint = new HashMap<>();

    public void createIfAbsent(int i) {
        indexToPoint.putIfAbsent(i, new HashMap<>());
    }

    public void putIfAbsent(int i, int j, Point point) {
        indexToPoint.get(i).putIfAbsent(j, point);
    }

    public Map<Integer, Point> get(Integer index) {
        return indexToPoint.get(index);
    }
}
