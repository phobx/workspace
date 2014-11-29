package deadlock;

public class DeadlockMain {
	public static void main(String[] args) {
		SyncHolder syncHolder = new SyncHolder();
		ThreadA threadA = new ThreadA(syncHolder);
		ThreadB threadB = new ThreadB(syncHolder);

		threadA.start();
		threadB.start();
	}
}
