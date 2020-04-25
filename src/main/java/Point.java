public class Point {
    final int x;
    final int y;
    private int numberOfPeopleAtPoint;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void incrementNumberOfPeopleAtPoint(int numberOfPeopleAtPoint) {
        this.numberOfPeopleAtPoint += numberOfPeopleAtPoint;
    }

    public int getCostForPoint(Point otherPoint) {
        return getDistance(otherPoint)*otherPoint.numberOfPeopleAtPoint;
    }

    private int getDistance(Point otherPoint) {
        return Math.abs(otherPoint.x - this.x) + Math.abs(otherPoint.y - this.y);
    }
}
