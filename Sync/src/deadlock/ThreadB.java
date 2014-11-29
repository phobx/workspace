package deadlock;

public class ThreadB extends Thread {

	SyncHolder syncHolder;

	public ThreadB(SyncHolder syncHolder) {
		this.syncHolder = syncHolder;
	}

	@Override
	public void run() {
		synchronized (syncHolder.b) {
			System.out.println("I locked B");
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			System.out.println("Now I am trying to lock A");
			synchronized (syncHolder.a) {
				System.out.println("I will never get here... :( ");
			}
		}
	}
}
