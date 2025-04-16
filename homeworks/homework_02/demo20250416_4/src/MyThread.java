public class MyThread extends Thread {


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " start");
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " делится на 2" );
            }
        }
        System.out.println(name + " finish");
    }


}
