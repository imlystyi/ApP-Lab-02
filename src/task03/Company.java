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

public class Company {
    // region Fields

    public final Schedule schedule = new Schedule();
    private final List<Plane> availablePlanes = new ArrayList<>();
    private final List<Airport> airports = new ArrayList<>();

    // endregion

    // region Methods

    public void addPlane(final int capacity, final String model) {
        availablePlanes.add(new Plane(model, capacity));
    }

    public void addFlight(final Airport departureAirport, final Airport arrivalAirport, double ticketCost,
                          final int planeIndex, final Calendar departureTime) {
        if (airports.stream().noneMatch(a -> Objects.equals(a.getCode(), departureAirport.getCode()))) {
            throw new IllegalArgumentException("Departure airport not found.");
        }

        if (airports.stream().noneMatch(a -> Objects.equals(a.getCode(), arrivalAirport.getCode()))) {
            throw new IllegalArgumentException("Arrival airport not found.");
        }

        schedule.addFlight(departureAirport, arrivalAirport, ticketCost, departureTime,
                           availablePlanes.get(planeIndex));
    }

    public void addAirport(final String code) {
        airports.add(new Airport(code));
    }

    public void editAirport(final String code, final String newCode) {
        int index = airports.indexOf(
                airports.stream().filter(a -> Objects.equals(a.getCode(), code)).findFirst().orElse(null));

        if (index == -1) {
            throw new IllegalArgumentException("Airport not found.");
        }

        Airport airport = airports.get(index);
        airport.setCode(newCode);
        airports.set(index, airport);
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
}
