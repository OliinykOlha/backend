public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int N_Workers = 5;

        TaskBoard taskBoard = new TaskBoardImpl(3);


        Thread[] workers = new Thread[N_Workers];
        for (int i = 0; i < N_Workers; i++) {
            workers[i] = new Thread(new Worker("worker" + i, taskBoard));
            workers[i].setDaemon(true);
            workers[i].start();
        }

        Thread manager = new Thread(new Manager(taskBoard, 20 ));
        manager.start();
        manager.join();


        Thread.sleep(200);

    }
}