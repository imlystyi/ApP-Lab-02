/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied Programming",
 * Laboratory work #02,
 * Task #03,
 * "Company.java" file */

package task03;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Company {
    // region Fields

    public final Schedule schedule = new Schedule();
    private final List<Plane> availablePlanes = new ArrayList<>();
    private final List<Airport> airports = new ArrayList<>();
    private final TicketService ticketService = new TicketService();

    // endregion

    // region Methods

    public void addPlane(final Plane plane) {
        availablePlanes.add(plane);
    }

    public void addFlight(final Flight flight) {
        if (airports.stream().noneMatch(a -> Objects.equals(a.getCode(), flight.getDepartureAirport().getCode()))) {
            throw new IllegalArgumentException("Departure airport not found.");
        }

        if (airports.stream().noneMatch(a -> Objects.equals(a.getCode(), flight.getArrivalAirport().getCode()))) {
            throw new IllegalArgumentException("Arrival airport not found.");
        }

        schedule.addFlight(flight);
    }

    public void addAirport(final Airport airport) {
        airports.add(airport);
    }

    public void editAirport(final String code, final String newCode) {
        Airport airport = airports.stream().filter(a -> Objects.equals(a.getCode(), code)).findFirst()
                                  .orElseThrow(() -> new IllegalArgumentException("Airport not found."));

        airport.setCode(newCode);
    }

    public void editPlane(final int number, final int capacity, final String model) {
        availablePlanes.set(number, new Plane(model, capacity));
    }

    public void deleteFlight(final int index) {
        schedule.removeFlight(index);
    }

    public void deletePlane(final int number) {
        availablePlanes.remove(number);
    }

    // endregion

    // region Nested classes

    public class TicketService {
        public void purchaseTicket(final int flightIndex, final Passenger passenger, final Calendar purchaseDate) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.purchaseTicket(passenger, purchaseDate);
        }

        public void editDepartureAirport(final int flightIndex, Airport airport) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editDepartureAirport(airport);
        }

        public void editArrivalAirport(final int flightIndex, Airport airport) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editArrivalAirport(airport);
        }

        public void editTicketCost(final int flightIndex, final double ticketCost) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editTicketCost(ticketCost);
        }

        public void editDepartureTime(final int flightIndex, final Calendar departureTime) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editDepartureTime(departureTime);
        }

        public void editPassenger(final int flightIndex, final UUID id, final String firstName, final String lastName,
                                  final Sex sex) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editPassenger(id, firstName, lastName, sex);
        }

        public void editPlane(final int flightIndex, final String model, final int capacity) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.editPlane(model, capacity);
        }

        public void cancelTicket(final int flightIndex, final int ticketNumber) {
            List<Flight> flights = schedule.getFlights();
            Flight flight = flights.get(flightIndex);
            flight.cancelTicket(ticketNumber);
        }
    }

    // endregion
}
