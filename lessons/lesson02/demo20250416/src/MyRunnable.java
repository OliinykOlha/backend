public class MyRunnable implements Runnable {

    // Наследуеться от интерфеса
    // в мейн создаем new Thread(runable)
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("(i) Thread " + name + "start");
        for (int i = 0; i < 5; i++) {
            System.out.println("(i)"+ name + " " + i);
        }
        System.out.println("(i) Thread " + name + "finish");
    }
    }

