public class MyThread extends Thread{
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Welcome from " + name + " " + i);
        }
    }
}
