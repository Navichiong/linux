package com.lwc.linux.apple;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Son implements Runnable {

	private Plate plate;

	private Lock lock = new ReentrantLock();

	public Son(Plate plate) {
		super();
		this.plate = plate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				plate.takeApple();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
