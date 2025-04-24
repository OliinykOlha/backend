public class Main {
    public static void main(String[] args) {

      Document doc1 = new Document(1, "Doc1");
      Document doc2 = new Document(2, "Doc2");

      doc1.addRelatedDocument(doc2);
      doc2.addRelatedDocument(doc1);

      Runnable task1 = () -> doc1.edit();
      Runnable task2 = () -> doc2.edit();

      Thread thread1 = new Thread(task1);
      Thread thread2 = new Thread(task2);

      thread1.start();
      thread2.start();

    }
}