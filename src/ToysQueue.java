import java.util.*;

/**
 * Класс предоставляет возможность добавления игрушек для розыгрыша
 * и получение случайной игрушки.
 * Каждая игрушка задана названием, идентификатором и долей в общем количестве случаев выпадения.
 * В классе автоматически подсчитывается статистика по выдаваемым игрушкам.
 */
public class ToysQueue {

    private List<Integer> indexList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<Integer> frequencyList = new ArrayList<>();
    private int maxValue;
    private List<Integer> randoms = new ArrayList<>();
    private HashMap<Integer, Integer> toysResults = new HashMap<>();
    private int countOfGets;

    /**
     * Добавляет игрушку к розыгрышу.
     * @param str Строка состоящая из нескольких слов. Первое - идентификатор,
     *            второе частота выпадения, остальное - наименование.
     */
    public void put(String str) {

        String[] strings = str.split(" ");
        if (strings.length > 2) {
            indexList.add(Integer.parseInt(strings[0]));
            frequencyList.add(Integer.parseInt(strings[1]));
            nameList.add(String.join(" ", Arrays.copyOfRange(strings, 2, strings.length)));
            maxValue += frequencyList.get(frequencyList.size() - 1);
        } else {
            System.out.println("Строка должна состоять из трех слов");
        }
    }

    /**
     * Получает случайную игрушку с учетом веса вероятности выпадения.
     * @return Строка из нескольких слов. Первое - идентификатор, остальные - наименование.
     */
    public String[] get() {
        int randomIndex = new Random().nextInt(maxValue);
        randoms.add(randomIndex);
        int i;
        for (i = 0; i < frequencyList.size(); i++) {
            if (randomIndex < frequencyList.get(i))
                break;
            randomIndex -= frequencyList.get(i);
        }
        toysResults.put(i, toysResults.getOrDefault(i, 0) + 1);
        String[] result = new String[2];
        result[0] = indexList.get(i).toString();
        result[1] = nameList.get(i);
        countOfGets++;
        return result;
    }

    /**
     * Получить статистику выполнения: все выброшенные случайные числа и процент выданных игрушек каждого вида.
     * @return
     */
    public String getStatistic() {
        StringBuilder sb = new StringBuilder();
        sb.append("Случайные числа: " + Arrays.toString(randoms.toArray()) + "\n");
        for (Integer key : toysResults.keySet()) {
            sb.append(nameList.get(key) + " " + (100 * toysResults.get(key) / countOfGets) + "%\n");
        }
        return sb.toString();
    }

    /**
     * Очищает данные статистки перед очередным розыгрышем.
     */
    public void clearStatistic() {
        countOfGets = 0;
        randoms = new ArrayList<>();
        toysResults = new HashMap<>();
    }
}
