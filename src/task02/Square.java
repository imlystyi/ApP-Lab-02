/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Square.java" file */

package task02;

public class Square extends FlatFigure {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side * 4;
    }

    @Override
    public double area() {
        return Math.pow(side, 2);
    }
}
