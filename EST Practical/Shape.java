public class Shape {

    void area() {
        System.out.println("Enter right parameter");
    }

    public class Circle {
        double area(float r) {
            return 3.14 * r * r;
        }
    }
    public class Rectangle {
        int area(int l, int b) {
            return l * b;
        }
    }

    public static void main(String[] args) {
        Shape s = new Shape();

        Shape.Circle c = s.new Circle();
        Shape.Rectangle r = s.new Rectangle();

        double a1 = c.area(5.9f);  
        int a2 = r.area(4, 6);

        System.out.println("Area of circle: " + a1);
        System.out.println("Area of rectangle: " + a2);
    }
}