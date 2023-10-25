import java.util.concurrent.Callable;

public class PiValueCallable implements Callable<Double> {

	private long iterations;
	
	public PiValueCallable(long itr) {
		this.iterations = itr;
	}
	
	
	@Override
	public Double call() throws Exception {
		
		double pi = 0;
		
		for(long i = 1; i <= this.iterations; i++) {
			pi += Math.pow(-1,  i + 1) / (2 * i - 1);
		}
		
		pi *= 4;
		
		return pi;

	}

}
