/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Schedule.java" file */

package task03;

import java.util.*;

public class Schedule {
    // region Fields

    private final List<Flight> flights = new ArrayList<>();

    // endregion

    // region Methods

    public void addFlight(final Airport departureAirport, final Airport arrivalAirport, double ticketCost,
                          final Calendar departureTime, final Plane plane) {
        flights.add(new Flight(departureAirport, arrivalAirport, ticketCost, departureTime, plane));
        Collections.sort(flights);
    }

    public void purchaseTicket(final int flightIndex, final Passenger passenger, final Calendar purchaseDate) {
        Flight flight = flights.get(flightIndex);
        flight.purchaseTicket(passenger, purchaseDate);
        flights.set(flightIndex, flight);
    }

    public void editDepartureAirport(final int flightIndex, Airport airport) {
        Flight flight = flights.get(flightIndex);
        flight.editDepartureAirport(airport);
        flights.set(flightIndex, flight);
    }

    public void editArrivalAirport(final int flightIndex, Airport airport) {
        Flight flight = flights.get(flightIndex);
        flight.editArrivalAirport(airport);
        flights.set(flightIndex, flight);
    }

    public void editTicketCost(final int flightIndex, final double ticketCost) {
        Flight flight = flights.get(flightIndex);
        flight.editTicketCost(ticketCost);
        flights.set(flightIndex, flight);
    }

    public void editDepartureTime(final int flightIndex, final Calendar departureTime) {
        Flight flight = flights.get(flightIndex);
        flight.editDepartureTime(departureTime);
        flights.set(flightIndex, flight);
    }

    public void editPassenger(final int flightIndex, final UUID id, final String firstName, final String lastName,
                              final Sex sex) {
        Flight flight = flights.get(flightIndex);
        flight.editPassenger(id, firstName, lastName, sex);
        flights.set(flightIndex, flight);
    }

    public void editPlane(final int flightIndex, final String model, final int capacity) {
        Flight flight = flights.get(flightIndex);
        flight.editPlane(model, capacity);
        flights.set(flightIndex, flight);
    }

    public void cancelTicket(final int flightIndex, final int ticketNumber) {
        Flight flight = flights.get(flightIndex);
        flight.cancelTicket(ticketNumber);
        flights.set(flightIndex, flight);
    }

    public void removeFlight(int index) {
        flights.remove(index);
    }

    public double getProfit(Calendar from, Calendar to) {

        double profit = 0;

        for (Flight f : flights) {
            if (f.getDepartureTime().compareTo(from) > 0) {
                profit += f.getProfit();
            } else if (f.getDepartureTime().compareTo(to) < 0) {
                profit += f.getProfit();
            }
        }

        return profit;
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();

        for (Flight f : flights) {
            stringRepresentation.append(f.toString()).append("\n");
        }

        return stringRepresentation.toString();
    }

    // endregion
}
