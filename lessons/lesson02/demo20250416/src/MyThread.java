public class MyThread extends Thread {


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread " + name + " start");
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(1000); // ждать секунду
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + name + " finish");
    }
}

