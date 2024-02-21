/* This is an example class for use with your generic ArrayList.
 * You don't have to modify anything in this class.
 */
public class Point implements Comparable<Point> {
    public float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Point)
                && x == ((Point) o).x
                && y == ((Point) o).y;
    }

    @Override
    public int compareTo(Point p) {
        return Math.round(x - p.x);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
