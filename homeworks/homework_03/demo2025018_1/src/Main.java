import java.util.ArrayList;

public class Main {
    private static final int N_BOX = 1000;
    private static final int CAPACITY = 1;

    public static void main(String[] args) {
    Warehouse warehouse = new Warehouse("#1");
    ArrayList<Loader> loaderList = new ArrayList<>();

        Thread[] loaders = {
                new Thread(new Loader("Jack", loaderList, N_BOX, CAPACITY, warehouse)),
                new Thread(new Loader("John", loaderList, N_BOX, CAPACITY, warehouse)),
                new Thread(new Loader("Piter", loaderList, N_BOX, CAPACITY, warehouse))
        };

        for(Thread thread: loaders) {
            thread.start();
        }

        for(Thread thread: loaders) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Loader winner = loaderList.stream()
                .findFirst()
                .orElse(null);

        if(winner!=null) {
            System.out.println("Winner is " + winner.getName());
        }

        System.out.println(warehouse);

    }
}