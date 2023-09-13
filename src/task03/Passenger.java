/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Passenger.java" file */

package task03;

import java.util.UUID;

public class Passenger {
    // region Fields

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final Sex sex;

    // endregion

    // region Constructors

    public Passenger(final UUID id, final String firstName, final String lastName, final Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    // endregion

    // region Methods

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    // endregion
}
