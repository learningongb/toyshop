
public class Main {
    public static void main(String[] args) {

        Logger logger = new Logger();

        ToysQueue toysQueue = new ToysQueue(logger);
        toysQueue.put(1, "конструктор", 2,10);
        toysQueue.put(2, "робот", 2,10);
        toysQueue.put(3, "кукла", 6,10);

        for (int i=0; i<10; i++) {
            toysQueue.get();
        }

        while (toysQueue.hasReceiving()) {
            System.out.println(toysQueue.receiveToy());
        }
    }
}