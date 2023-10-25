public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		int cores = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of cores: " + cores);
        
		PiValue pi1 = new PiValue(10);
		System.out.println("Pi1: " + pi1.calc());
		
		PiValue pi2 = new PiValue(20000);
		System.out.println("Pi2: " + pi2.calc());
	}
}
