/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Pyramid.java" file */

package task02;

public class Pyramid extends SolidFigure {
    private final Triangle base;
    private final double height;

    public Pyramid(final double firstBaseSide, final double secondBaseSide, final double thirdBaseSide,
                   final double height) {
        this.base = new Triangle(firstBaseSide, secondBaseSide, thirdBaseSide);
        this.height = height;
    }

    @Override
    public double volume() {
        return base.area() * height;
    }
}
