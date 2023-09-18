/* Vladyslav Yakubovskyi,
 * Lviv Polytechnic National University, Institute of Computer Science and Information Technologies,
 * Department of Information Systems and Networks, "PI-21" Student group,
 * Discipline "Applied programming",
 * Laboratory work #02,
 * Task #01,
 * "Stack.java" file */

package task01;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    // region Fields

    private Node<T> top;

    // endregion

    // region Constructors

    public Stack() {
        top = null;
    }

    // endregion

    // region Methods

    public void push(T item) {
        final Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        final T item = top.data;
        top = top.next;

        return item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        int size = 0;

        for (T ignored : this) {
            size++;
        }

        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                final T item = current.data;
                current = current.next;

                return item;
            }
        };
    }

    // endregion

    // region Nested classes

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(final T data) {
            this.data = data;
            this.next = null;
        }
    }

    // endregion
}
