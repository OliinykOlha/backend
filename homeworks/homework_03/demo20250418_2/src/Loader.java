import java.util.Random;

public class Loader implements Runnable {
    private String name;
    private int nBox;
    private int done1;
    private int done2;
    private Warehouse warehouse1;
    private Warehouse warehouse2;
    private Random random = new Random();

    public Loader(String name, int nBox, Warehouse warehouse1, Warehouse warehouse2) {
        this.name = name;
        this.nBox = nBox;
        this.warehouse1 = warehouse1;
        this.warehouse2 = warehouse2;
    }

    @Override
    public void run() {
        while(nBox > (done1 + done2)) {
            int remain = nBox - (done1 + done2);

            int take1 = remain >= 1 ? 1: 0;
            int take2 = remain >= 2 ? 1 : 0;

            if (take1 == 1) {
                warehouse1.addValue(1);
                done1++;
            }

            if(take2 == 1) {
                warehouse2.addValue(1);
                done2++;
            }

            try {
                Thread.sleep(5 + random.nextInt(11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(name + " took " + done1 + " boxes " + " to warehouse " + warehouse1.getName());
        System.out.println(name + " took " + done2 + " boxes " + " to warehouse " + warehouse2.getName());
    }
}
