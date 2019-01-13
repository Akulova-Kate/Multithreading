import java.util.PriorityQueue;

public class InputStorage {

    private static PriorityQueue<Integer> numbers = new PriorityQueue<>();
    private final Object monitor = new Object();

    public void addToList(int number) {
        synchronized (monitor) {
            numbers.add(number);
        }
    }

    public int findMinValueAndDelete() {
        synchronized (monitor) {
            if (numbers.isEmpty()) {
                throw new IllegalStateException("The storage with input numbers is empty!");
            } else {
               return numbers.poll();
            }
        }
    }
}
