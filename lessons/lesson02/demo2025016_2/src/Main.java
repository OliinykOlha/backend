import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Timer timer = new Timer();
        Thread thread = new Thread(timer);

        thread.setDaemon(true);

        thread.start();

        while(true) {
            System.out.println("Input timeOut or Press q for stop");
            String str = scanner.nextLine();
            if(str.equals("q")) {
                break;
            } else {
                timer.setTimeOut(Integer.parseInt(str)); // сканер читает строку переделываем в int
            }  try {

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            }


        System.out.println("Main finish");
    }

    }