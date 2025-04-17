public class Task extends Thread {

    private int factor;

    public Task(int factor) {
        this.factor = factor;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; true; i += factor) {

            System.out.println(name + " на " + factor + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



