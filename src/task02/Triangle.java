/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Triangle.java" file */

package task02;

public class Triangle extends FlatFigure {
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double perimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double area() {
        return 1 / 4. * Math.sqrt((firstSide + secondSide + thirdSide) * (secondSide + thirdSide - firstSide) *
                                  (firstSide + thirdSide - secondSide) * (firstSide + secondSide - thirdSide));
    }
}
