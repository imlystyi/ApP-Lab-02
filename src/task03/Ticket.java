/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Ticket.java" file */

package task03;

import java.util.Calendar;

public class Ticket {
    private final Passenger passenger;
    private final Calendar purchaseDate;

    public Ticket(final Passenger passenger, final Calendar purchaseDate) {
        this.passenger = passenger;
        this.purchaseDate = purchaseDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Calendar getPurchaseDate() {
        return purchaseDate;
    }
}
