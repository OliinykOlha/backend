public class Main {
    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.println(name + " " + id + " Start");

        Thread  thread_1 = new Thread() { // анонимный класс и он наследует Threads
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "Start анономный клас");
            }
        };

        Thread[] threads = {
                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() +  " Start Lambda");
                }),
                thread_1
        };

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {  // когда завершаться все треды
            thread.join();
        }

       // threads[threads.length-1].join(); - когда завершиться последний тред

        Thread.sleep(1000);
        System.out.println(name + " " + "Finish");
    }
}