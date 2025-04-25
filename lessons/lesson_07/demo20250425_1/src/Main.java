public class Main {
    private final static int N_Tasks = 20;
    private final static int N_Workers = 5;

    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl2();

        Thread manager = new Thread(new Manager(taskBoard, N_Tasks));

        Thread[] threads = new Thread[N_Workers];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(taskBoard, "Jack-" + i));
            threads[i].setDaemon(true);
            threads[i].start();
        }


        manager.start();
        manager.join();

    }
}