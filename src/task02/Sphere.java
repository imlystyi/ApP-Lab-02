/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Sphere.java" file */

package task02;

public class Sphere extends SolidFigure {
    private final double radius;

    public Sphere(final double radius) {
        this.radius = radius;
    }

    @Override
    public double volume() {
        return 4. / 3 * Math.PI * Math.pow(radius, 3);
    }
}
