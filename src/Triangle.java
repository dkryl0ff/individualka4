public class Triangle<T extends Point> {
    private String id;
    private T v1, v2, v3;

    public Triangle(String id, T v1, T v2, T v3) {
        this.id = id;
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public void move(double deltaX, double deltaY) {
        v1 = (T) new Point(v1.getX() + deltaX, v1.getY() + deltaY);
        v2 = (T) new Point(v2.getX() + deltaX, v2.getY() + deltaY);
        v3 = (T) new Point(v3.getX() + deltaX, v3.getY() + deltaY);
    }

    public String getId() {
        return id;
    }

    public T[] getVertices() {
        return (T[]) new Point[]{v1, v2, v3};
    }

    public boolean isIntersect(Tetragon<?> t) {
        for (int i = 0; i < 4; i++) { // Изменяем 3 на 4 для Tetragon
            Point a1 = getVertices()[i];
            Point a2 = getVertices()[(i + 1) % 4]; // Корректируем доступ к вершинам
            for (int j = 0; j < 4; j++) { // Цикл также для 4-х точек Tetragon
                Point b1 = t.getVertices()[j];
                Point b2 = t.getVertices()[(j + 1) % 4];
                if (linesIntersect(a1, a2, b1, b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean linesIntersect(Point a1, Point a2, Point b1, Point b2) {
        double A1 = a2.getY() - a1.getY();
        double B1 = a1.getX() - a2.getX();
        double C1 = A1 * a1.getX() + B1 * a1.getY();

        double A2 = b2.getY() - b1.getY();
        double B2 = b1.getX() - b2.getX();
        double C2 = A2 * b1.getX() + B2 * b1.getY();

        double determinant = A1 * B2 - A2 * B1;

        if (determinant == 0) {
            return false;
        } else {
            double x = (B2 * C1 - B1 * C2) / determinant;
            double y = (A1 * C2 - A2 * C1) / determinant;

            return isPointOnSegment(a1, a2, x, y) && isPointOnSegment(b1, b2, x, y);
        }
    }

    private boolean isPointOnSegment(Point a, Point b, double x, double y) {
        return Math.min(a.getX(), b.getX()) <= x && x <= Math.max(a.getX(), b.getX()) &&
                Math.min(a.getY(), b.getY()) <= y && y <= Math.max(a.getY(), b.getY());
    }

}
