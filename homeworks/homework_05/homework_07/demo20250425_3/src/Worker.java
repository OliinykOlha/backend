public class Worker implements Runnable {
    private final  String name;
    private final TaskBoard taskBoard;

    public Worker(String name, TaskBoard taskBoard) {
        this.name = name;
        this.taskBoard = taskBoard;
    }

    @Override
    public void run() {
        while (true) {
        String task = taskBoard.getTask();
            System.out.println(task + " " + name);
        }
    }
}
