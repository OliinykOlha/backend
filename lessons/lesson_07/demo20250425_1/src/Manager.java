public class Manager implements Runnable {
    private TaskBoard taskBoard;
    private final int nTASK;

    public Manager(TaskBoard taskBoard, int nTASK) {
        this.taskBoard = taskBoard;
        this.nTASK = nTASK;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTASK; i++) {
            taskBoard.setTask("task " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

