
public class Main {

	public static void main(String[] args) {
		
		
		int[] array = new int[200000000];
		
		for(int i = 0; i <= 199999999;i++) {
			
			int rand = (int)(Math.random()*10 + 1);
			array[i] = rand;
				
		
		}
		
		
		long startMulti;
		long endMulti;
		
		long startSingle;
		long endSingle;
		
		SumThread t1= new SumThread(0,50000000,array);
		SumThread t2= new SumThread(50000001,100000000,array);
		SumThread t3= new SumThread(100000001,150000000,array);
		SumThread t4= new SumThread(150000001,199999999,array);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		startMulti = System.currentTimeMillis();
		
		
		//Waiting until all threads finish
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endMulti = System.currentTimeMillis();
		
		System.out.println("Multiple threads took "+ ((endMulti-startMulti)/1000) +" seconds");
		System.out.println("Sum equals " + SumThread.sum);
		
		SumThread.sum = 0;
		
		SumThread single = new SumThread(0,199999999,array);
		
		single.start();
		startSingle = System.currentTimeMillis();
		
		
		try {
			single.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		endSingle = System.currentTimeMillis();
		
		System.out.println("Single thread took "+ ((endSingle-startSingle)/1000) +" seconds");
		System.out.println("Sum equals " + SumThread.sum);
		
		
	
		
		

	}

}
