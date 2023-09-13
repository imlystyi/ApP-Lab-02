/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #02,
 * "Main.java" file */

package task02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FlatFigure> flatFigures = new ArrayList<>();
        flatFigures.add(new Circle(4));
        flatFigures.add(new Triangle(3, 4, 5));
        flatFigures.add(new Square(5));
        flatFigures.add(new Rectangle(6, 8));

        for (FlatFigure ff : flatFigures) {
            System.out.println(ff.area());
            System.out.println(ff.perimeter() + "\n");
        }

        List<SolidFigure> solidFigures = new ArrayList<>();
        solidFigures.add(new Sphere(5));
        solidFigures.add(new Pyramid(4, 5, 6, 7));
        solidFigures.add(new Cube(5));

        for (SolidFigure sf : solidFigures) {
            System.out.println(sf.volume() + "\n");
        }
    }
}
