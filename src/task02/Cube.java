/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Cube.java" file */

package task02;

public class Cube extends SolidFigure {
    private final double side;

    public Cube(final double side) {
        this.side = side;
    }

    @Override
    public double volume() {
        return Math.pow(side, 3);
    }
}
