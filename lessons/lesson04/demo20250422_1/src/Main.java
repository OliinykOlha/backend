public class Main {
    public static void main(String[] args) throws InterruptedException {

       MyThread myThread = new MyThread();
       myThread.start();


            Thread.sleep(3000);

        myThread.setFinish(true);
        System.out.println( myThread.isFinish());

        for(int i=0; i< 5; i++) {
            System.out.println(myThread.getCounter());
        }

        System.out.println("Main finish");


    }
}