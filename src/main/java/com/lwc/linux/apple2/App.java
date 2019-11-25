package com.lwc.linux.apple2;

import java.util.concurrent.Semaphore;

public class App {
    //信号量为2表示盘子为空，信号量为1表示盘子中有1个水果，信号量为0表示盘子中有2个水果
    public static Semaphore diskEmpty = new Semaphore(2);
    //信号量为2表示盘子中有2个橘子，信号量为1表示盘子中有1个橘子，信号量为0表示盘子中没有橘子
    public static Semaphore haveOrange = new Semaphore(0);
    //信号量为2表示盘子中有2个苹果，信号量为1表示盘子中有1个苹果，信号量为0表示盘子中没有苹果
    public static Semaphore haveApple = new Semaphore(0);
    //互斥信号量，放水果和拿水果是一种互斥操作
    public static Semaphore mute=new Semaphore(1);

	
	public static void main(String[] args) {
		
		Plate plate = new Plate();
		Father father = new Father(plate);
		Mother mother = new Mother(plate);
		Son son = new Son(plate);
		Daughter daughter = new Daughter(plate);
		
		Thread tf = new Thread(father);
		tf.setName("爸爸");
		
		Thread tm = new Thread(mother);
		tm.setName("妈妈");
		
		Thread ts1 = new Thread(son) ;
		ts1.setName("大儿子");
		
		Thread ts2 = new Thread(son);
		ts2.setName("小儿子");
		
		Thread td1 = new Thread(daughter);
		td1.setName("大女儿");
		
		Thread td2 = new Thread(daughter);
		td2.setName("小女儿");

		tf.start();
		tm.start();
		ts1.start();
		ts2.start();
		td1.start();
		td2.start();
	}
}
