package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHolder {

	private AtomicInteger data = new AtomicInteger();

	public int getData() {
		return data.intValue();
	}

	public void increaseData() {
		data.incrementAndGet();
	}

	/*
	 * private int data = 0;
	 * 
	 * public int getData() { return data; }
	 * 
	 * public synchronized void increaseData() { data++; }
	 */
}
