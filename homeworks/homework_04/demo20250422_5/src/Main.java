public class Main {
    public static void main(String[] args) throws InterruptedException {

        LatencyMonitor monitor = new LatencyMonitor();

        Thread[] threads = new  Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> generateLatencies(monitor));
        }


      for (Thread thread : threads) {
          thread.start();
      }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Minimal latency " + monitor.getMinLatency() + " ms");

    }

    private static void generateLatencies(LatencyMonitor monitor) {
        for (int i = 0; i < 10; i++) {
            double latency = Math.random() * Integer.MAX_VALUE;
            monitor.updateLatency(latency);
        }
    }
}