public class Tetragon<T extends Point> {
    private String id;
    private T v1, v2, v3, v4;

    public Tetragon(String id, T v1, T v2, T v3, T v4) {
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }

    public void move(double deltaX, double deltaY) {
        v1 = (T) new Point(v1.getX() + deltaX, v1.getY() + deltaY);
        v2 = (T) new Point(v2.getX() + deltaX, v2.getY() + deltaY);
        v3 = (T) new Point(v3.getX() + deltaX, v3.getY() + deltaY);
        v4 = (T) new Point(v4.getX() + deltaX, v4.getY() + deltaY);
    }

    public String getId() {
        return id;
    }

    public T[] getVertices() {
        return (T[]) new Point[]{v1, v2, v3, v4};
    }
}
