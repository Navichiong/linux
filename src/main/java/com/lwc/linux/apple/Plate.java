package com.lwc.linux.apple;

import java.util.ArrayList;
import java.util.List;

public class Plate {

	private List<Fruit> fruits = new ArrayList<>(2);
	private int appleNum;
	private int orangeNum;

	public int getAppleNum() {
		return appleNum;
	}

	public void setAppleNum(int appleNum) {
		this.appleNum = appleNum;
	}

	public int getOrangeNum() {
		return orangeNum;
	}

	public void setOrangeNum(int orangeNum) {
		this.orangeNum = orangeNum;
	}

	public void putApple() {
		synchronized (this) {
			if (fruits.size() < 2) {
				fruits.add(Fruit.APPLE);
				appleNum++;
				System.out.println(Thread.currentThread().getName() + "放了一个苹果");
			} else {
				System.out.println(Thread.currentThread().getName() + "等待放苹果");
			}
			System.out.println(fruits);
		}
	}

	public void putOrange() {
		synchronized (this) {
			if (fruits.size() < 2) {
				fruits.add(Fruit.ORANGE);
				orangeNum++;
				System.out.println(Thread.currentThread().getName() + "放了一个橘子");
			} else {
				System.out.println(Thread.currentThread().getName() + "等待放橘子");
			}
			System.out.println(fruits);
		}
	}

	public void takeApple() {
		synchronized (this) {
			if (fruits.size() > 0 && appleNum > 0) {
				for (Fruit fruit : fruits) {
					if (fruit != null && fruit.equals(Fruit.APPLE)) {
						fruits.remove(fruit);
						appleNum--;
						System.out.println(Thread.currentThread().getName() + "拿了一个苹果");
						break;
					}
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "等待苹果放入盘子");
			}
			System.out.println(fruits);
		}
	}

	public void takeOrange() {
		synchronized (this) {
			if (fruits.size() > 0 && orangeNum > 0) {
				for (Fruit fruit : fruits) {
					if (fruit != null && fruit.equals(Fruit.ORANGE)) {
						fruits.remove(fruit);
						orangeNum--;
						System.out.println(Thread.currentThread().getName() + "拿了一个橘子");
						break;
					}
				}
			} else {
				System.out.println(Thread.currentThread().getName() + "等待橘子放入盘子");
			}
			System.out.println(fruits);
		}
	}

	public List<Fruit> getFruits() {
//		synchronized (this) {
			return fruits;
//		}
	}

	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "Plate [fruits=" + fruits + "]";
	}

}
