import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {

    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);

    public void updateLatency(double latency) {
        int newLatency = (int) latency;

        while (true) {
            int currentMin = minLatency.get();
            if( newLatency >= currentMin) {
                return;
            }
            if(minLatency.compareAndSet(currentMin, newLatency)) {
                return;
            }
        }
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}
