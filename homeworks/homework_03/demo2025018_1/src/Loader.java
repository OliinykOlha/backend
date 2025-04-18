import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int capacity;
    private Warehouse warehouse;
    private int done;
    List<Loader> loaderList;
    private Object lock= new Object();
    private Random random = new Random();



    public Loader(String name, List<Loader> loaderList, int nBox, int capacity, Warehouse warehouse) {
        this.name = name;
        this.loaderList = loaderList;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while(done < nBox) {
            int value = Math.min(nBox - done, capacity);
            warehouse.addValue(value);
            done+=capacity;
            try {
                Thread.sleep(5 + random.nextInt(11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        synchronized (lock) {
            loaderList.add(this);
        }
    }
}
