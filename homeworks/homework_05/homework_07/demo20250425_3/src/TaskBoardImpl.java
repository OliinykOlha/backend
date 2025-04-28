import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl implements TaskBoard {
    private final Queue<String> taskQueue;
    private final int capacity;
    private final Lock lock;
    private final Condition managerCondition;
    private final Condition workerCondition;

    public TaskBoardImpl(int capacity) {
        this.taskQueue = new LinkedList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.managerCondition = lock.newCondition();
        this.workerCondition = lock.newCondition();
    }

    @Override
    public void setTask(String task) {
        lock.lock();
        try {
            while (taskQueue.size() == capacity) {
                try {
                    managerCondition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            taskQueue.offer(task);
            workerCondition.signalAll();

        } finally {
            lock.unlock();
        }

    }


    @Override
    public String getTask() {
        lock.lock();
        try {
            while (taskQueue.isEmpty()) {
                try {
                    workerCondition.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            String task = taskQueue.poll();
            managerCondition.signal();
            return task;
        } finally {
            lock.unlock();
        }

    }
}
