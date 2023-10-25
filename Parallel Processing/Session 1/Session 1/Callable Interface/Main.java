import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws Exception {
		
		parallel();
		nonParallel();
		
	}
	
	private static void parallel() throws Exception {
		
		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService es = Executors.newFixedThreadPool(cores);  
		
		long startTime = System.nanoTime();
		
		Future<Double> f1 = es.submit(new PiValueCallable(50000000));
		Future<Double> f2 = es.submit(new PiValueCallable(60000000));
		Future<Double> f3 = es.submit(new PiValueCallable(70000000));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f3.get());
		
		System.out.println("Execution time (parallel) : "
				+ TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS) + " ms");

		es.shutdown();
		
	}
	
	private static void nonParallel() throws Exception {
		
		long startTime = System.nanoTime();
		
		PiValueCallable piValueCallable1 = new PiValueCallable(50000000);
		PiValueCallable piValueCallable2 = new PiValueCallable(60000000);
		PiValueCallable piValueCallable3 = new PiValueCallable(70000000);
		
		System.out.println(piValueCallable1.call());
		System.out.println(piValueCallable2.call());
		System.out.println(piValueCallable3.call());
		
		System.out.println("Execution time (non parallel) : "
				+ TimeUnit.MILLISECONDS.convert(System.nanoTime() - startTime, TimeUnit.NANOSECONDS) + " ms");
	
	}

}
