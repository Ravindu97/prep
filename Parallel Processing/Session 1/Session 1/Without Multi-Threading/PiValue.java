public class PiValue {
	
	private double pi=0;
	private long iterations;

	public PiValue(long iterations){
		this.iterations=iterations;
	}	
	public double calc() {
		//Pi/4 = 1 - 1/3 + 1/5 - 1/7 + 1/9 ...
		for(long i = 1; i <= iterations; i++) {
			
			this.pi += Math.pow(-1,  i + 1) / (2 * i - 1);
		}
		
		this.pi *= 4;
		
		return this.pi;
	}
	
}
