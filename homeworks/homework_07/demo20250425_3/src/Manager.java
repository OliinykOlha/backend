public class Manager implements  Runnable {
    private final TaskBoard taskBoard;
    private final int nTasks;

    public Manager(TaskBoard taskBoard, int nTasks) {
        this.taskBoard = taskBoard;
        this.nTasks = nTasks;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTasks; i++) {
            taskBoard.setTask("task " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
