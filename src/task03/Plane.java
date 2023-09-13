/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Plane.java" file */

package task03;

public class Plane {
    private String model;
    private int capacity;

    public Plane(final String model, final int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(final int capacity) {
        this.capacity = capacity;
    }

    public void setModel(final String model) {
        this.model = model;
    }
}
