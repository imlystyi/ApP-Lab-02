/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Ticket.java" file */

package task03;

import java.util.Calendar;
import java.util.UUID;

public class Ticket {
    private final UUID ownerId;
    private final Calendar purchaseDate;

    public Ticket(final UUID ownerId, final Calendar purchaseDate) {
        this.ownerId = ownerId;
        this.purchaseDate = purchaseDate;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Calendar getPurchaseDate() {
        return purchaseDate;
    }
}
