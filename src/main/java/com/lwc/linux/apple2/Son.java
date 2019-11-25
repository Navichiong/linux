package com.lwc.linux.apple2;

public class Son implements Runnable {

	private Plate plate;

	public Son(Plate plate) {
		super();
		this.plate = plate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				App.haveOrange.acquire();
				App.mute.acquire();
				plate.takeOrange();
				System.out.println(plate.getFruits());
				Thread.sleep(1000);
				App.mute.release();
				App.diskEmpty.release();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
