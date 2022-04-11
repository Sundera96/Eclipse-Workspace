import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserAPI {

	class LongRunningAction implements Runnable {
	    private String threadName;
	    private Phaser ph;

	    LongRunningAction(String threadName, Phaser ph) {
	        this.threadName = threadName;
	        this.ph = ph;
	        ph.register();
	    }

	    @Override
	    public void run() {
	    	System.out.println("before arrive " + threadName);
	        ph.arriveAndAwaitAdvance();
	        System.out.println("after arrive" + threadName);
	        try {
	            Thread.sleep(20);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        ph.arriveAndDeregister();
	    }
	}
	
	public static void sleepHelper(int millis) {
		try {
			System.out.println("ABout to Sleep for " + millis);
			Thread.sleep(millis);
			System.out.println("Slept for " + millis);
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);
		PhaserAPI phaserRunner = new PhaserAPI();
		executorService.submit(phaserRunner.new LongRunningAction("thread-1", ph));
		executorService.submit(phaserRunner.new LongRunningAction("thread-2", ph));
		//executorService.submit(phaserRunner.new LongRunningAction("thread-3", ph));
		
		System.out.println("before arriveAndAwaitAdvance");
		sleepHelper(100);
		ph.arriveAndAwaitAdvance();
		System.out.println("after arriveAndAwaitAdvance");

		System.out.println("Hello");
		executorService.submit(phaserRunner.new LongRunningAction("thread-4", ph));
		executorService.submit(phaserRunner.new LongRunningAction("thread-5", ph));
		sleepHelper(100);
		System.out.println("Holla");
		System.out.println("before arriveAndAwaitAdvance");
		ph.arriveAndAwaitAdvance();
		System.out.println("after arriveAndAwaitAdvance");
		ph.arriveAndDeregister();
		System.out.println("after arriveAndDeregister");
		
	}
}
