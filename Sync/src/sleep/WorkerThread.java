package sleep;

public class WorkerThread extends Thread {

	public Task taskToDo;
	public Object sync = new Object();

	@Override
	public void run() {
		while (true) {
			synchronized (sync) {
				try {
					sync.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (taskToDo != null) {
					taskToDo.doTask();
				}
			}
		}
	}
}
