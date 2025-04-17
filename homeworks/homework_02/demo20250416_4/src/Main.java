public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");

        MyThread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main finish");

    }
}
