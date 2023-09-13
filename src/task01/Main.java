/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #02,
 * Task #01,
 * "Main.java" file */

package task01;

public class Main {
    public static void main(String[] args) {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        final int size = stack.size();

        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
}
