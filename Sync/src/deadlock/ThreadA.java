package deadlock;

public class ThreadA extends Thread {

	SyncHolder syncHolder;

	public ThreadA(SyncHolder syncHolder) {
		this.syncHolder = syncHolder;
	}

	@Override
	public void run() {
		synchronized (syncHolder.a) {
			System.out.println("I locked A");
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			System.out.println("Now I am trying to lock B");
			synchronized (syncHolder.b) {
				System.out.println("I will never get here... :( ");
			}
		}
	}

}
