/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Flight.java" file */

package task03;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Flight implements Comparable<Flight> {
    // region Fields

    private Airport departureAirport;
    private Airport arrivalAirport;
    private double ticketCost;
    private Calendar departureTime;
    private final Plane plane;
    public final List<Ticket> tickets;
    public final List<Passenger> passengers;

    // endregion

    // region Constructors

    public Flight(final Airport departureAirport, final Airport arrivalAirport, final double ticketCost,
                  final Calendar departureTime, final Plane plane) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.ticketCost = ticketCost;
        this.plane = plane;
        this.departureTime = departureTime;
        this.tickets = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // endregion

    // region Methods

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public double getProfit() {
        return ticketCost * tickets.size();
    }

    public void purchaseTicket(final Passenger passenger, final Calendar purchaseDate) {
        if (passengers.stream().anyMatch(p -> p.getId() == passenger.getId())) {
            throw new IllegalArgumentException("Passenger already has a ticket.");
        }

        tickets.add(new Ticket(passenger.getId(), purchaseDate));
        passengers.add(passenger);
    }

    public void editDepartureAirport(final Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public void editArrivalAirport(final Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void editTicketCost(final double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public void editDepartureTime(final Calendar departureTime) {
        this.departureTime = departureTime;
    }

    public void editPassenger(final UUID id, final String firstName, final String lastName, final Sex sex) {
        int index = passengers.indexOf(passengers.stream().filter(p -> p.getId() == id).findFirst().orElse(null));
        if (index == -1) {
            throw new IllegalArgumentException("Passenger not found.");
        }

        final Passenger passenger = passengers.get(index);
        passengers.set(index, new Passenger(id, (firstName != null ? firstName : passenger.getFirstName()),
                                            (lastName != null ? lastName : passenger.getLastName()),
                                            (sex != null ? sex : passenger.getSex())));

    }

    public void editPlane(final String model, final int capacity) {
        if (passengers.size() > capacity) {
            throw new IllegalArgumentException("Plane capacity is too small.");
        }

        plane.setModel(model);
        plane.setCapacity(capacity);
    }

    public void cancelTicket(final int number) {
        UUID passengerId = tickets.get(number).getOwnerId();
        tickets.remove(number);
        passengers.removeIf(p -> p.getId() == passengerId);
    }

    @Override
    public int compareTo(Flight flight) {
        return departureTime.compareTo(flight.getDepartureTime());
    }

    @Override
    public String toString() {
        return String.format("""
                                     %s - %s
                                     DT: %s
                                     P: %d""", departureAirport.getCode(), arrivalAirport.getCode(),
                             departureTime.getTime(), passengers.size());
    }

    // endregion
}
