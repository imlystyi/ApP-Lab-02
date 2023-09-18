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
    private final List<Flight> flights = new ArrayList<>();

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(final Flight flight) {
        flights.add(flight);
        Collections.sort(flights);
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
}
