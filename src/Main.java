public class Main {
    public static void main(String[] args) {
        try {
            Triangle<Point> t1 = new Triangle<>("T1", new Point(0.0, 0.0), new Point(1.0, 0.0), new Point(0.5, 1.0));
            Tetragon<Point> t2 = new Tetragon<>("T2", new Point(0.5, 0.5), new Point(1.5, 0.5),
                    new Point(2.0, 1.5), new Point(1.0, 2.0));

            System.out.println("Идентификатор треугольника: " + t1.getId());
            System.out.println("Идентификатор четырехугольника: " + t2.getId());

            System.out.println("Пересекаются ли объекты (до перемещения): " + t1.isIntersect(t2));

            t1.move(0.5, 0.5);
            t2.move(0.5, 0.5);

            System.out.println("Перемещение объектов...");

            System.out.println("Пересекаются ли объекты (после перемещения): " + t1.isIntersect(t2));

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ClassCastException e) {
            System.out.println("Ошибка преобразования типов: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}
