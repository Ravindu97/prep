public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of cores: " + cores);
        
		PiValueThread thread1 = new PiValueThread("thread1", 10000000);
		PiValueThread thread2 = new PiValueThread("thread2", 10);

		thread1.start();
		thread2.start();
	}
}
