package sleep;

public class SleepMain {
	public static void main(String[] args) throws Exception {
		WorkerThread slave = new WorkerThread();
		slave.setDaemon(true);
		slave.start();

		slave.taskToDo = new TaskA();
		synchronized (slave.sync) {
			slave.sync.notify();
		}

		Thread.sleep(2000);

		slave.taskToDo = new TaskB();
		synchronized (slave.sync) {
			slave.sync.notify();
		}
	}
}
