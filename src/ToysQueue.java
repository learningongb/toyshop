import java.util.*;

/**
 * Класс предоставляет возможность добавления игрушек для розыгрыша
 * и получение случайной игрушки.
 * Каждая игрушка задана названием, идентификатором и долей в общем количестве случаев выпадения.
 * В классе автоматически подсчитывается статистика по выдаваемым игрушкам.
 */
public class ToysQueue {

    private Queue<Toy> receiving = new ArrayDeque<>();
    private List<Toy> toyList = new ArrayList<>();
    private Logger logger;

    public ToysQueue(Logger logger) {
        this.logger = logger;
    }

    /**
     * Добавляет игрушку к розыгрышу.
     * @param str Строка состоящая из нескольких слов. Первое - идентификатор,
     *            второе частота выпадения, третье - количество, остальное - наименование.
     */
    public void put(int id, String name, int frequency, int count) {

        toyList.add(new Toy(id, name, frequency, count));

    }

    /**
     * Выбирает случайноую игрушку и добавляет ее в очередь к выдаче
     * @return
     */
    public void get() {
        int randomIndex = new Random().nextInt(getMaxValue());
        for (Toy toy : toyList) {
            if (toy.getCount() != 0) {
                if (randomIndex < toy.getFrequency()) {
                    receiving.add(toy);
                    toy.decrementCount();
                    break;
                }
                randomIndex -= toy.getFrequency();
            }
        }
    }

    /**
     * Выдает одну игрушку и пишет событие в лог.
     * @return
     */
    public Toy receiveToy() {
        Toy toy = receiving.poll();
        logger.log(toy.toString());
        return toy;
    }

    /**
     * Проверяет есть ли в очереди игрушки к выдаче.
     * @return
     */
    public boolean hasReceiving() {
        return !receiving.isEmpty();
    }

    private int getMaxValue() {
        int result = 0;
        for (Toy toy : toyList) {
            if (toy.getCount() > 0)
                result += toy.getFrequency();
        }
        return result;
    }
}
