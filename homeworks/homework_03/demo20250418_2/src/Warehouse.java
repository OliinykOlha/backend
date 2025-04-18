public class Warehouse {

    private String name;
    private int value;
    private Object lock = new Object();

    public Warehouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        synchronized (lock) {
            return value;
        }
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void addValue(int value) {
        synchronized (lock) {
            this.value += value;
        }

    }

}