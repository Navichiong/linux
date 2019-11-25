package com.lwc.linux.apple2;


public class Mother implements Runnable {

	private Plate plate;

	public Mother(Plate plate) {
		super();
		this.plate = plate;
	}

	@Override
	public void run() {
		while (true) {
			try {
				App.diskEmpty.acquire();
				App.mute.acquire();
				plate.putOrange();
				System.out.println(plate.getFruits());
				Thread.sleep(1000);
				App.mute.release();
				App.haveOrange.release();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
