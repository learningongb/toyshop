public class Toy {
    private int id;
    private String name;
    private int frequency;
    private int count;

    public Toy(int id, String name, int frequency, int count) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }

    /**
     * Уменьшает доступное количество игрушек
     */
    public void decrementCount() {
        this.count--;
    }
}
