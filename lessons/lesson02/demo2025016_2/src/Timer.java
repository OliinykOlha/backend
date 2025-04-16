import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer implements Runnable {

   private int timeOut = 3;

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public void run() {
        while (true) {
            System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
            try {
                Thread.sleep(timeOut *1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
