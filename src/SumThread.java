
public class SumThread extends Thread {

	static public double sum;
	private int lowerLimit;
	private int upperLimit;
	private int[] array;
	
	public SumThread(int lowerLimit, int upperLimit, int[] array) {
		super();
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.array = array;
	}
	
	
	static public synchronized void addSum(int value) {
		
		sum += value;
		
	}
	


	@Override
	public void run() {
		
		for(int i = lowerLimit; i <= upperLimit;i++) {
		
			addSum(array[i]);
			
		
		}
		
		
		
		
	}
	
	
	
	
	
	
}
