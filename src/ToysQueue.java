import java.util.PriorityQueue;

public class ToysQueue {

    PriorityQueue<Toy> queue = new PriorityQueue<>();

    void put(Toy toy) {
        queue.add(toy);
    }
}
