public class PiValueRunnable implements Runnable{
	
	private long iterations;
	private String runnableId;
	private double pi;
	
	public PiValueRunnable(String runnableId, long iterations) {
		this.iterations = iterations;
		this.runnableId = runnableId;
	}
	
	public void run() {
		//Pi/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 ...
		for(long i = 1; i <= this.iterations; i++) {
			this.pi += Math.pow(-1,  i + 1) / (2 * i - 1);
		}
		
		this.pi *= 4;
		
		System.out.println("Pi Value (" + this.runnableId + "): " + getValue());
	}
	
	public double getValue() {
		return this.pi;
	}

}
