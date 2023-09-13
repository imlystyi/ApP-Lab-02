/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Rectangle.java" file */

package task02;

public class Rectangle extends FlatFigure {
    private final double firstSide;
    private final double secondSide;

    public Rectangle(double firstSide, double secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    @Override
    public double perimeter() {
        return 2 * firstSide + 2 * secondSide;
    }

    @Override
    public double area() {
        return firstSide * secondSide;
    }
}
