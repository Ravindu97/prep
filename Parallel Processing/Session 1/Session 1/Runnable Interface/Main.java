public class Main {
    public static void main(String[] args) {
        PiValueRunnable piValueRunnable1 = new PiValueRunnable("runnable1", 1000000);
        PiValueRunnable piValueRunnable2 = new PiValueRunnable("runnable2", 10);

        Thread thread1 = new Thread(piValueRunnable1);
        Thread thread2 = new Thread(piValueRunnable2);

        thread1.start();
        thread2.start();
    }
}
